package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFound;
import com.example.entity.Cart;
import com.example.repo.CartRepo;
import com.example.service.CartService;


@Service
public class CartServiceImpl implements CartService {

	
	@Autowired
	CartRepo cartRepo;
	
	
	@Override
	public Cart addcart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepo.save(cart);
	}

	@Override
	public List<Cart> getAllCarts() {
		// TODO Auto-generated method stub
		return cartRepo.findAll();
	}

	@Override
	public Cart cartUpdate(int cartId, Cart cart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCart(int cartId) {
		// TODO Auto-generated method stub
		Cart cart=cartRepo.findById(cartId).orElseThrow(()-> new ResourceNotFound(cartId+"id not found"));

		cartRepo.delete(cart);
	}

	@Override
	public Cart getById(int cartId) {
		// TODO Auto-generated method stub
		
		
		Cart cart=cartRepo.findById(cartId).orElseThrow(()-> new ResourceNotFound(cartId+"id not found"));
		return cart;
	}

	@Override
	public Cart getByUserId(int userId) {
		// TODO Auto-generated method stub
		
		return cartRepo.findByuserId(userId);
	}

	
	
	
	
}
