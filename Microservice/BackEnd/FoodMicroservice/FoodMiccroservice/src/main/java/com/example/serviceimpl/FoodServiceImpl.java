package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFound;
import com.example.entity.Food;
import com.example.feignclient.RestaurantController;
import com.example.model.Category;
import com.example.repo.FoodRepo;
import com.example.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

	
	@Autowired
	FoodRepo foodRepo;
	
	
	@Autowired
	RestaurantController restaurantController;
	
	
	
	@Override
	public Food addFood(Food food) {
		// TODO Auto-generated method stub
		return foodRepo.save(food);
	}

	@Override
	public List<Food> getAllFoods() {
		// TODO Auto-generated method stub
		return foodRepo.findAll();
	}

	@Override
	public Food foodUpdate(int foodId, Food food) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFood(int foodId) {
		// TODO Auto-generated method stub
		Food food=foodRepo.findById(foodId).orElseThrow(() -> new ResourceNotFound(foodId+"food id not found"));

		foodRepo.delete(food);
	}

	@Override
	public Food getById(int foodId) {
		// TODO Auto-generated method stub
		
		
		Food food=foodRepo.findById(foodId).orElseThrow(() -> new ResourceNotFound(foodId+"food id not found"));
		
		return food;
		
		
	}

	@Override
	public List<Food> getFoodByRestId(int restId) {
		// TODO Auto-generated method stub
		return foodRepo.findByrestId(restId);
	}

	@Override
	public List<Food> getFoodByCategory(String category) {
		// TODO Auto-generated method stub
	
		
		return foodRepo.findBycategory(category);
	}

	@Override
	public List<String> getuniqueCategory() {
		// TODO Auto-generated method stub
		
		List<String> categoryList=new ArrayList<>(); 
		
		List<Food> foods=this.getAllFoods();
		
		for(Food f:foods)
		{
			categoryList.add(f.getCategory().toLowerCase());
		}
		
		
		List<String> categoryList2=categoryList.stream().distinct().collect(Collectors.toList());
		
		
		return categoryList2;
	}

	@Override
	public List<Category> getCategoryWithImage() {
		
		
		List<String> uniqueList=this.getuniqueCategory();
		
		List<Category> categories=new ArrayList<>();
		for(int i=0;i< uniqueList.size();i++)
		{
			List<Food> foods=new ArrayList<>();
			
			foods=this.getFoodByCategory(uniqueList.get(i));
			
			Category  category=new Category(uniqueList.get(i),foods.get(0).getImage());
			
			categories.add(category);
			
		}
		return  categories;
		
	}

	@Override
	public List<Food> getByFoodType(String foodtype,int restId) {
		// TODO Auto-generated method stub
		
		
		return foodRepo.findByfoodTypeAndRestId(foodtype,restId);
	}

	@Override
	public List<Food> getByFoodTypeAndCategory(String string, String category) {
		// TODO Auto-generated method stub
		return foodRepo.findByfoodTypeAndCategory(string, category);
	}

	
	
	
	
	

}
