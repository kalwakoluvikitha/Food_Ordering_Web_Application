package com.example.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Model.AddToCart;



@FeignClient(name = "ADDTOCART-SERVICE/addtocart")
public interface AddToCartController {

	@PostMapping("/")
	public AddToCart addAddToCart(@RequestBody AddToCart addToCart);
	
	@GetMapping("/cart/{cartId}")
	public List<AddToCart> byCartId(@PathVariable int cartId);
	
	
}
