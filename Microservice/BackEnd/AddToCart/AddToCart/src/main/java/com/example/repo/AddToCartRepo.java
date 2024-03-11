package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AddToCart;



public interface AddToCartRepo extends JpaRepository<AddToCart, Integer> {

	List<AddToCart> findBycartId(int cartId);
	
	
	
	AddToCart  findByFoodIdAndCartId(int foodId, int addtocartId);
	
	void deleteAllBycartId(int cartId);
	
	
	
}
