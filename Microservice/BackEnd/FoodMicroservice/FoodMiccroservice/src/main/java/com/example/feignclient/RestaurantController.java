package com.example.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Restaurant;

;

@FeignClient(name = "RESTAURANT-SERVICE/restaurant")
public interface RestaurantController {
	
	@GetMapping("/{restId}")
	public Restaurant getRestaurantById(@PathVariable int restId);

}
