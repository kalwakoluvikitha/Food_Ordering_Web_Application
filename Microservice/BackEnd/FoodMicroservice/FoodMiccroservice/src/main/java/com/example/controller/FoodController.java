package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Food;
import com.example.model.Category;
import com.example.service.FoodService;



@RestController
@RequestMapping("/food")
@CrossOrigin(origins =  "http://localhost:4200")
public class FoodController {
	
	
	
	@Autowired
	FoodService foodService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Food>>   getAll()
	{
	     List<Food> Foods=foodService.getAllFoods();
		return  new ResponseEntity<List<Food>>(Foods,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Food> addFood(@RequestBody Food food)
	{
		
		System.out.println(food);
	Food Food2=foodService.addFood(food);
		//Food Food2=new Food();
		return new ResponseEntity<Food>(Food2,HttpStatus.ACCEPTED);
		
		
	}
	
	
	
	
	@GetMapping("/{foodId}")
	public ResponseEntity<Food> getFoodById(@PathVariable int foodId)
	{
		Food food=foodService.getById(foodId);
		return new ResponseEntity<Food>(food,HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/{foodId}")
	public ResponseEntity<?> deleteFoodById(@PathVariable int foodId)
	{
	foodService.deleteFood(foodId);
		return (ResponseEntity<?>) ResponseEntity.ok();
		
		
	}
	
	
	@GetMapping("/restaurant/{restId}")
	public ResponseEntity<List<Food>> getFoodByRestId(@PathVariable int restId)
	{
		List<Food> foods=foodService.getFoodByRestId(restId);
		return new ResponseEntity<List<Food>>(foods,HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/category/")
	public ResponseEntity<List<Food>> getFoodByCategory(@RequestParam(name = "category") String category)
	{
		List<Food> foods=foodService.getFoodByCategory(category);
		return new ResponseEntity<List<Food>>(foods,HttpStatus.ACCEPTED);
		
		
	}
	
	
	@GetMapping("/uniqueCategory")
	public ResponseEntity<List<String>> getUnqiueCategory()
	{
		List<String> category=foodService.getuniqueCategory();
		return new ResponseEntity<List<String>>(category,HttpStatus.ACCEPTED);
	}
	
	

	@GetMapping("/getCategory")
	public ResponseEntity<List<Category>> getCategoryWithImage()
	{
		
		System.out.println("running");
		List<Category> category=foodService.getCategoryWithImage();
		return new ResponseEntity<List<Category>>(category,HttpStatus.ACCEPTED);
	}
	
	
	
	@GetMapping("/pureveg/{restId}")
	public ResponseEntity<List<Food>> getByFoodTypeUsingRestId(@PathVariable int restId )
	{
		List<Food> foods=foodService.getByFoodType("veg",restId);
		 return new ResponseEntity<List<Food>>(foods,HttpStatus.ACCEPTED);
	}
	

	
	
	@GetMapping("/pureveg")
	public ResponseEntity<List<Food>> getByFoodType(@RequestParam(name = "category") String category )
	{
		List<Food> foods=foodService.getByFoodTypeAndCategory("veg",category);
		System.out.println(category);
		 return new ResponseEntity<List<Food>>(foods,HttpStatus.ACCEPTED);
	}
	
}
