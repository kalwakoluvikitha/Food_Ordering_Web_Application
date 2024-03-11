package com.example.service;

import java.util.List;

import com.example.entity.AddToCart;



public interface AddToCartService {

	
	
	AddToCart addaddtocart(AddToCart  addtocart);
	
	
	List<AddToCart>  getAllAddToCarts();
	
	
	AddToCart addtocartUpdate(int addtocartId,AddToCart addtocart);
	
	void deleteAddToCart(int addtocartId);
	
	
	AddToCart getById(int addtocartId);


	List<AddToCart> getByCartId(int cartId);


	int increaseQuantity(int addtocartId, int quantity);


	int decreaseQuantity(int addtocartId, int quantity);


	void deleteAllByUserId(int cartId);
	
}
