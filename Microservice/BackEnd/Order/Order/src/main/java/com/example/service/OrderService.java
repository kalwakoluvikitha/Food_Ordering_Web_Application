package com.example.service;

import java.util.List;

import com.example.entity.Order;

public interface OrderService {
	Order addOrder(Order  order);
	
	
	List<Order>  getAllOrders();
	
	
	Order orderUpdate(int orderId,Order order);
	
	void deleteOrder(int orderId);
	
	
	Order getById(int orderId);


	List<Order> getByUserId(int userId);
	
	
}
