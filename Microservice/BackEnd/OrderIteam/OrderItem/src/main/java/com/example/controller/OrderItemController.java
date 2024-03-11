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

import com.example.Model.Order;
import com.example.entity.OrderItem;

import com.example.service.OrderItemService;


@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
	
	

	@Autowired
	OrderItemService orderItemService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<OrderItem>>   getAll()
	{
	     List<OrderItem> OrderItems=orderItemService.getAllOrderItems();
		return  new ResponseEntity<List<OrderItem>>(OrderItems,HttpStatus.OK);
	}
	
	@PostMapping("/{userId}")
	public ResponseEntity<Order> addOrderItem(@RequestBody OrderItem orderItem,@PathVariable int userId )
	{
		Order OrderItem2=orderItemService.addOrderItem(orderItem,userId);
		return new ResponseEntity<Order>(OrderItem2,HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/{orderItemId}")
	public ResponseEntity<OrderItem> getOrderItemById(@PathVariable int orderItemId)
	{
		OrderItem orderItem=orderItemService.getById(orderItemId);
		return new ResponseEntity<OrderItem>(orderItem,HttpStatus.ACCEPTED);
		
		
	}
	
	
	@DeleteMapping("/{orderItemId}")
	public ResponseEntity<?> deleteOrderItemById(@PathVariable int orderItemId)
	{
	orderItemService.deleteOrderItem(orderItemId);
		return (ResponseEntity<?>) ResponseEntity.ok();
		
		
	}
	
	
	@PostMapping("/userId/{userId}/{address}")
	public ResponseEntity<Order>   byall(@PathVariable int userId,@PathVariable String address)
	{
		Order order=orderItemService.byall(userId,address);
		
		return new ResponseEntity<Order>(order,HttpStatus.ACCEPTED);
		
	}
	
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Order>>  orderByUser(@PathVariable int userId)
	{
		 
		List<Order> orders=orderItemService.getByUserId(userId);
		return new ResponseEntity<List<Order>>(orders,HttpStatus.ACCEPTED);
	}
	
	

}
