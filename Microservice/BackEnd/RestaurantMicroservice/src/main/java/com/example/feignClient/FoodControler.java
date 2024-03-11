package com.example.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Food;



@FeignClient(name = "FOOD-SERVICE/food")
public interface FoodControler {
	
	@GetMapping("/restaurant/{restId}")
	public List<Food> getFoodByRestId(@PathVariable int restId);

}
