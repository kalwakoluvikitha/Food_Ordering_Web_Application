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

import com.example.entity.Cart;
import com.example.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	
	@Autowired
	CartService cartService;
	
	@GetMapping("/")
	public ResponseEntity<List<Cart>>   getAll()
	{
	     List<Cart> carts=cartService.getAllCarts();
		return  new ResponseEntity<List<Cart>>(carts,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart)
	{
		Cart cart1=cartService.addcart(cart);
		return new ResponseEntity<Cart>(cart,HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/{cartId}")
	public ResponseEntity<Cart> getCartById(@PathVariable int cartId)
	{
		Cart cart1=cartService.getById(cartId);
		return new ResponseEntity<Cart>(cart1,HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/{cartId}")
	public ResponseEntity<?> deleteCartById(@PathVariable int cartId)
	{
		cartService.deleteCart(cartId);
		return (ResponseEntity<?>) ResponseEntity.ok();
		
		
	}

	@GetMapping("/userId/{userId}")
	public ResponseEntity<Cart> getByUserID(@PathVariable int userId)
	{
		Cart cart=cartService.getByUserId(userId);
		return new ResponseEntity<Cart>(cart,HttpStatus.ACCEPTED);
		
	}
	
	
	
}
