package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {
	
	
	
	List<Food> findByrestId(int restId);
	
	
	
	List<Food> findBycategory(String category);
	
	List<Food> findByfoodType(String foodType);
	
	List<Food> findByfoodTypeAndRestId(String foodType,int restId);

    List<Food> findByfoodTypeAndCategory(String foodType, String category);
}
