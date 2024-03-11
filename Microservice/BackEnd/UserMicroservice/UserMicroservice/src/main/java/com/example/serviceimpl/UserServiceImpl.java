package com.example.serviceimpl;

import java.util.List;
import java.util.ArrayList;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFound;
import com.example.Exception.UserAlreadyExist;
import com.example.Model.AddToCart;
import com.example.Model.Cart;
import com.example.Model.CartIteam;
import com.example.Model.Food;
import com.example.Model.GroupByOrder;
import com.example.Model.Item;
import com.example.Model.Order;
import com.example.Model.OrderItem;
import com.example.Model.PlacedOrders;
import com.example.entity.User;
import com.example.feignClient.AddToCartController;
import com.example.feignClient.CartController;
import com.example.feignClient.FoodController;
import com.example.feignClient.OrderItemController;
import com.example.repo.UserRepo;
import com.example.srvice.UserService;


@Service
public class UserServiceImpl   implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	CartController cartController;
	
	
	@Autowired
	AddToCartController addToCartController;
	
	
	@Autowired
	OrderItemController orderItemController;
	
	@Autowired
	FoodController foodController;
	
	
	@Override
	public User adduser(User user) {
		// TODO Auto-generated method stub
		//duplicatemail checking and phono
		
		User user2=userRepo.findByEmail(user.getEmail());
		User user3=userRepo.findByPhoneNo(user.getPhoneNo());
		
		if(user2!=null)
		{
			throw new UserAlreadyExist("User Already Exists");
		}
		if(user3!=null)
		{
			throw new UserAlreadyExist("Phone no Already Exists");
		}
		
		if(user2==null &&user3==null)
		{
		
		
		userRepo.save(user);
		Cart cart=new Cart();
		cart.setUserId(user.getUserId());
		Cart cart1=cartController.addCart(cart);
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User userUpdate(int userId, User user) {
		// TODO Auto-generated method stub
		User user1= userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("user not found"+userId));

		User user2=userRepo.findByEmail(user.getEmail());
		User user3=userRepo.findByPhoneNo(user.getPhoneNo());
		
		
		
		if((user2.getUserId()==userId || user2==null )&& (user3.getUserId()!=userId || user3==null))
		{
			
			user1.setEmail(user.getEmail());
			user1.setPhoneNo(user.getPhoneNo());
            user1.setUserName(user.getPassword());
            user1.setAddress(user.getAddress());
            user1.setUserName(user.getUserName());
            
            
			
			
		}
		else {
			throw new UserAlreadyExist("User Already Exists");
		}
		
		
		
		
		return user1;
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		User user= userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("user not found"+userId));

		userRepo.delete(user);
		
		
	}

	@Override
	public User getById(int userId) {
		// TODO Auto-generated method stub
		
		
		User user= userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("user not found"+userId));
		return user;
	}

	@Override
	public AddToCart addAddToCart(AddToCart addToCart,int userId) {
		// TODO Auto-generated method stub
		
		
		Cart cart=cartController.getByUserID(userId);
		
		
		addToCart.setCartId(cart.getCartId());
		addToCart.setQuantity(1);
		AddToCart addToCart2=addToCartController.addAddToCart(addToCart);
		
		
		return addToCart;
	}

	@Override
	public Order buynow(Item item) {
		// TODO Auto-generated method stub
		
		
		OrderItem orderItem=new OrderItem();
		
		orderItem.setFoodId(item.getFoodId());
		orderItem.setQuantity(item.getQuantity());
		
		
	    Food food	=foodController.getFoodById(item.getFoodId());
	    orderItem.setTotalprice(food.getPrice()*item.getQuantity());
		Order order=orderItemController.addOrderItem(orderItem, item.getUserId());
		
		System.out.println(order);
		return order;
	}

	@Override
	public Order byall(int userId,String address) {
		// TODO Auto-generated method stub
		User user= userRepo.findById(userId).orElseThrow(() -> new ResourceNotFound("user not found"+userId));
	   Cart cart=cartController.getByUserID(userId);
		
	       Order order =orderItemController.byall(userId,address);
	       addToCartController.deleteAllByUserId(cart.getCartId());
	       System.out.println(order);
		
		return order;
	}

	@Override
	public User loginuser(String email, String password) {
		// TODO Auto-generated method stub
		 User user=userRepo.findByEmailAndPassword(email, password);
		
		
		return user;
	}

	@Override
	public List<CartIteam> atcartByUserId(int userId) {
		// TODO Auto-generated method stub
		
		Cart cart=cartController.getByUserID(userId);
		List<AddToCart> addToCarts=addToCartController.byCartId(cart.getCartId());
		List<CartIteam> cartIteams=new ArrayList<>();
		System.out.println(addToCarts);
		for(AddToCart a:addToCarts)
		{
			Food food=foodController.getFoodById(a.getFoodId());
			CartIteam cartIteam=new CartIteam(a.getAddtocartId(),food.getFoodId(),food.getFoodName(),food.getPrice(),food.getImage(),a.getQuantity());
			cartIteams.add(cartIteam);
			
		}
		System.out.println(cartIteams);
		
		
		return cartIteams;
	}

	@Override
	public int increaseQuantity(int addtocartId, int quantity) {
		// TODO Auto-generated method stub
		return addToCartController.increaseQuantity(addtocartId, quantity);
	}

	@Override
	public int decreaseQuantity(int addtocartId, int quantity) {
		// TODO Auto-generated method stub
		return addToCartController.decreaseQuantity(addtocartId, quantity);
	}

	@Override
	public void deletecartIteam(int addtocartId) {
		// TODO Auto-generated method stub
		addToCartController.deleteAddToCartById(addtocartId);
		
	}

	@Override
	public List<PlacedOrders> orderByUser(int userId) {
		
		  List<Order> orders=orderItemController.orderByUser(userId);
		  
		  List<PlacedOrders> placedOrders=new ArrayList<>();
		  
		  for(Order i:orders)
		  { 
//			  PlacedOrders p=new PlacedOrders();
//			  p.setOrderId(i.getOrderId());
//			  p.setBillingAddress(i.getBillingAddress());
//			  p.setOrderAmount(i.getOrderAmount());
			  for(OrderItem j:i.getOrderItems())
			  {
				  PlacedOrders p=new PlacedOrders();
				  p.setOrderId(i.getOrderId());
				  p.setBillingAddress(i.getBillingAddress());
				  p.setOrderAmount(i.getOrderAmount());
				  p.setFoodId(j.getFoodId());
				  p.setQuantity(j.getQuantity());
				  p.setTotalprice(j.getTotalprice());
				  Food food=foodController.getFoodById(j.getFoodId());
				  p.setFoodName(food.getFoodName());
				  p.setDate(i.getDate());
				  
				  placedOrders.add(p);
				  
			  }
			  
			  
		  }
		  
		
		// TODO Auto-generated method stub
		return placedOrders;
	}
	
	
	public List<GroupByOrder> grouporder(int userId)
	{
		List<PlacedOrders> placedOrders=this.orderByUser(userId);
		System.out.println(placedOrders);
		
		List<GroupByOrder> groupByOrders=new ArrayList<>();
		
		
		
		
		List<Order> order=orderItemController.orderByUser(userId);
		
	   
		int j=0;
		
		for(Order order2:order)
		{
			j=j+1;
			GroupByOrder g=new GroupByOrder();
			g.setGroupId(j);
			
			g.setOrderAmount(order2.getOrderAmount());
			g.setDate(order2.getDate());
			 List<PlacedOrders> placedOrders2=new ArrayList<>();
			 for(PlacedOrders p:placedOrders)
			 {
				 if(p.getOrderId()==order2.getOrderId())
				 {
					 
					 placedOrders2.add(p);
					 
					 
				 }
			 }
			 
			 g.setPlacedOrders(placedOrders2);
			 groupByOrders.add(g);
			
		}
	   System.out.println(groupByOrders);
		return groupByOrders;
	}
		
		
		
		
	
	
	
	
	
	
	
	

}
