package com.example.service;

import java.util.List;

import com.example.entity.Food;
import com.example.model.Category;



public interface FoodService {

	
	Food addFood(Food  food);
	
	
	List<Food>  getAllFoods();
	
	
	Food foodUpdate(int foodId,Food food);
	
	void deleteFood(int foodId);
	
	
	Food getById(int foodId);


	List<Food> getFoodByRestId(int restId);


	List<Food> getFoodByCategory(String category);


	List<String> getuniqueCategory();


	List<Category> getCategoryWithImage();


	List<Food> getByFoodType(String string,int restId);


	List<Food> getByFoodTypeAndCategory(String string,String category);
	
	
	
	
}
