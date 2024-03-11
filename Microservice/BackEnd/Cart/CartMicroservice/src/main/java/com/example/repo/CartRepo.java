package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Cart;
import java.util.List;


public interface CartRepo extends JpaRepository<Cart, Integer> {

	
	
	
	Cart  findByuserId(int userId);
}
