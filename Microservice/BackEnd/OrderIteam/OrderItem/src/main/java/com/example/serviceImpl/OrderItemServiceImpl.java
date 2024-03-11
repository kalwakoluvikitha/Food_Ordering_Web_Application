package com.example.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFound;
import com.example.FeignClient.AddToCartController;
import com.example.FeignClient.CartController;
import com.example.FeignClient.FoodController;
import com.example.FeignClient.OrderController;
import com.example.Model.AddToCart;
import com.example.Model.Cart;
import com.example.Model.Order;
import com.example.entity.OrderItem;
import com.example.repo.OrderItemRepo;
import com.example.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepo orderItemRepo;

	@Autowired
	OrderController orderController;

	@Autowired
	CartController cartController;

	@Autowired
	AddToCartController addToCartController;

	@Autowired
	FoodController foodController;

	@Override
	public Order addOrderItem(OrderItem orderItem, int userId) {
		// TODO Auto-generated method stub

		Order order = new Order();
		order.setOrderAmount(orderItem.getTotalprice());
		order.setUserId(userId);

		Order order2 = orderController.addOrder(order);

		OrderItem orderItem2 = new OrderItem();

		orderItem.setOrderId(order2.getOrderId());

		List<OrderItem> orderItems = Arrays.asList(orderItem);
		order2.setOrderItems(orderItems);
		orderItemRepo.save(orderItem);
		return order2;
	}

	@Override
	public List<OrderItem> getAllOrderItems() {
		// TODO Auto-generated method stub
		return orderItemRepo.findAll();
	}

	@Override
	public OrderItem orderItemUpdate(int orderItemId, OrderItem orderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		// TODO Auto-generated method stub

		OrderItem orderItem = orderItemRepo.findById(orderItemId)
				.orElseThrow(() -> new ResourceNotFound(orderItemId + "food id not found"));

		orderItemRepo.delete(orderItem);
	}

	@Override
	public OrderItem getById(int orderItemId) {
		// TODO Auto-generated method stub

		OrderItem orderItem = orderItemRepo.findById(orderItemId)
				.orElseThrow(() -> new ResourceNotFound(orderItemId + "food id not found"));

		return orderItem;
	}

	@Override
	public Order byall(int userId,String address) {
		// TODO Auto-generated method stub

		Cart cart = cartController.getByUserID(userId);

		List<AddToCart> addToCarts = addToCartController.byCartId(cart.getCartId());

		Double totalDouble = 0.0;

		for (AddToCart a : addToCarts) {
			totalDouble  =totalDouble+ (double) (a.getPrice() * a.getQuantity());
			System.out.println(totalDouble);

		}

		Order order = new Order();
		order.setUserId(userId);
		order.setOrderAmount(totalDouble);
		order.setBillingAddress(address);

		Order order2 = orderController.addOrder(order);

		Double totalPrice = 0.0;
		List<OrderItem> orderItems=new ArrayList<>();
		for (AddToCart toCart : addToCarts) {

			OrderItem orderItem = new OrderItem();
			orderItem.setFoodId(toCart.getFoodId());
			orderItem.setQuantity(toCart.getQuantity());
			orderItem.setOrderId(order2.getOrderId());
			orderItem.setTotalprice(toCart.getPrice() * toCart.getQuantity());
			orderItemRepo.save(orderItem);
			orderItems.add(orderItem);

		}

		
		order2.setOrderItems(orderItems);
		return order2;
	}

	@Override
	public List<Order> getByUserId(int userId) {
		// TODO Auto-generated method stub\\\
		
		List<Order> orders=orderController.orderByUser(userId);
		for(Order order:orders)
		{
			List<OrderItem> orderItems =orderItemRepo.findByOrderId(order.getOrderId());
			order.setOrderItems(orderItems);
			
		}
		
		
		return orders;
	}

}
