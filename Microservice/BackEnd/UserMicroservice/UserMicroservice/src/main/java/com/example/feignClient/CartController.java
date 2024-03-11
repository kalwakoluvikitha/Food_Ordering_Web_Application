package com.example.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Model.Cart;

@FeignClient(name = "CART-SERVICE/cart")
public interface CartController {

	@PostMapping("/")
	public Cart addCart(@RequestBody Cart cart);
	
	
	
	@GetMapping("/userId/{userId}")
	public Cart getByUserID(@PathVariable int userId);

}
