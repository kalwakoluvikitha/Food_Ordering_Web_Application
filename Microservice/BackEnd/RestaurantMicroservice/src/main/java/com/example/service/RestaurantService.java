package com.example.service;

import java.util.List;

import com.example.entity.Restaurant;


public interface RestaurantService {

	
	
Restaurant addRestaurant(Restaurant  restaurant);
	
	
	List<Restaurant>  getAllRestaurants();
	
	
	Restaurant restaurantUpdate(int restId,Restaurant restaurant);
	
	void deleteRestaurant(int restId);
	
	
	Restaurant getById(int restrId);
}
