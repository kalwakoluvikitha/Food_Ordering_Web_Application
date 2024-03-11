package com.example.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Model.Order;



@FeignClient(name="ORDER-SERVICE/order")
public interface OrderController {

	
	
	@PostMapping("/")
	public Order addOrder(@RequestBody Order order);
	
	
	@GetMapping("/user/{userId}")
	public List<Order>  orderByUser(@PathVariable int userId);
	
	
	
	
	
}
