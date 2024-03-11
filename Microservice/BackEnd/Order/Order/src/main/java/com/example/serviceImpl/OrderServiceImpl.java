package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFound;
import com.example.Model.User;
import com.example.entity.Order;
import com.example.feignClient.UserController;
import com.example.repo.OrderRepo;
import com.example.service.OrderService;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class OrderServiceImpl   implements OrderService {

	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	UserController userController;
	
	
	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		
		Format f = new SimpleDateFormat("MM/dd/yy");
		String strDate = f.format(new Date());
		System.out.println("Current Date = "+strDate);
		User user=userController.getUserById(order.getUserId());
		Order order2=new Order();
		order2.setUserId(order.getUserId());
		order2.setBillingAddress(user.getAddress());
		order2.setOrderStatus("true");
		order2.setPayamentStatus("done");
		order2.setOrderAmount(order.getOrderAmount());
		order2.setDate(new Date());
		return   orderRepo.save(order2) ;
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll();
	}

	@Override
	public Order orderUpdate(int orderId, Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		Order order=orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFound(orderId+"food id not found"));

		orderRepo.delete(order);
		
	}

	@Override
	public Order getById(int orderId) {
		// TODO Auto-generated method stub
		
		Order order=orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFound(orderId+"food id not found"));

		return order;
	}

	@Override
	public List<Order> getByUserId(int userId) {
		// TODO Auto-generated method stub
		
		List<Order> orders=orderRepo.findByUserId(userId);
		
		
		
		
		
		return orders;
	}

}
