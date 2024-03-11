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
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Restaurant;
import com.example.service.RestaurantService;


@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins = "http://localhost:4200")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;
	
	
	@GetMapping("/")
	public ResponseEntity<List<Restaurant>>   getAll()
	{
		
		System.out.println("executing");
	     List<Restaurant> restaurants=restaurantService.getAllRestaurants();
		return  new ResponseEntity<List<Restaurant>>(restaurants,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant)
	{
		
		System.out.println(restaurant);
		Restaurant restaurant2=restaurantService.addRestaurant(restaurant);
		//Restaurant restaurant2=new Restaurant();
		return new ResponseEntity<Restaurant>(restaurant2,HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/{restId}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int restId)
	{
		Restaurant restaurant=restaurantService.getById(restId);
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/{restId}")
	public ResponseEntity<?> deleteRestaurantById(@PathVariable int restId)
	{
		restaurantService.deleteRestaurant(restId);
		return (ResponseEntity<?>) ResponseEntity.ok();
		
		
	}
}
