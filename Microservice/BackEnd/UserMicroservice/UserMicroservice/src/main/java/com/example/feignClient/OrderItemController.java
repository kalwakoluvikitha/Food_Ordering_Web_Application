package com.example.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Model.Order;
import com.example.Model.OrderItem;



@FeignClient(name="ORDERITEM-SERVICE/orderItem")
public interface OrderItemController {
	
	
	
	@PostMapping("/{userId}")
	public Order addOrderItem(@RequestBody OrderItem orderItem,@PathVariable int userId );
	
	
	@PostMapping("/userId/{userId}/{address}")
	public Order   byall(@PathVariable int userId,@PathVariable String address);
	
	
	@GetMapping("/user/{userId}")
	public List<Order>  orderByUser(@PathVariable int userId);
	
	
	
}
