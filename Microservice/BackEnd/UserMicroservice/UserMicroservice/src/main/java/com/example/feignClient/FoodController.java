package com.example.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Model.Food;



@FeignClient(name = "FOOD-SERVICE/food")
public interface FoodController {
	
	
	@GetMapping("/{foodId}")
	public Food getFoodById(@PathVariable int foodId);

}
