package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Food;



@FeignClient(name = "FOOD-SERVICE/food")
public interface FoodController {
	
	
	@GetMapping("/{foodId}")
	public Food getFoodById(@PathVariable int foodId);

}
