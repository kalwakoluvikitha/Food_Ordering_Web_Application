package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Order;
import com.example.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Order>>   getAll()
	{
	     List<Order> Orders=orderService.getAllOrders();
		return  new ResponseEntity<List<Order>>(Orders,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Order> addOrder(@RequestBody Order order)
	{
		Order Order2=orderService.addOrder(order);
		return new ResponseEntity<Order>(Order2,HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrderById(@PathVariable int orderId)
	{
		Order order=orderService.getById(orderId);
		return new ResponseEntity<Order>(order,HttpStatus.ACCEPTED);
		
		
	}
	
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> deleteOrderById(@PathVariable int orderId)
	{
	orderService.deleteOrder(orderId);
		return (ResponseEntity<?>) ResponseEntity.ok();
		
		
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Order>>  orderByUser(@PathVariable int userId)
	{
		 
		List<Order> orders=orderService.getByUserId(userId);
		return new ResponseEntity<List<Order>>(orders,HttpStatus.ACCEPTED);
	}
	
	
}
