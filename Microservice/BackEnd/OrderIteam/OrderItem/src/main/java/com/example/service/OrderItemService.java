package com.example.service;

import java.util.List;

import com.example.Model.Order;
import com.example.entity.OrderItem;

public interface OrderItemService {
	
	
	

	Order addOrderItem(OrderItem  orderItem,int userId);
	
	
	List<OrderItem>  getAllOrderItems();
	
	
	OrderItem orderItemUpdate(int orderItemId,OrderItem orderItem);
	
	void deleteOrderItem(int orderItemId);
	
	
	OrderItem getById(int orderItemId);


	Order byall(int userId,String address);


	List<Order> getByUserId(int userId);
	


}
