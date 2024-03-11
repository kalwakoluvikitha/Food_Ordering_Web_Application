package com.example.service;

import java.util.List;

import com.example.entity.Cart;

public interface CartService {

	
Cart addcart(Cart  cart);
	
	
	List<Cart>  getAllCarts();
	
	
	Cart cartUpdate(int cartId,Cart cart);
	
	void deleteCart(int cartId);
	
	
	Cart getById(int cartId);


	Cart getByUserId(int userId);
}
