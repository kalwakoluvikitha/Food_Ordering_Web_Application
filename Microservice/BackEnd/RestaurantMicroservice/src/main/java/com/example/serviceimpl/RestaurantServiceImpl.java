package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFound;
import com.example.entity.Restaurant;
import com.example.feignClient.FoodControler;
import com.example.model.Food;
import com.example.repo.RestaurantRepo;
import com.example.service.RestaurantService;
@Service
public class RestaurantServiceImpl implements RestaurantService {

	
	@Autowired
	RestaurantRepo restaurantRepo;
	
	
	@Autowired
	FoodControler foodController;
	
	
	
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		// TODO Auto-generated method stub
		return restaurantRepo.save(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		// TODO Auto-generated method stub
	
		List<Restaurant> restaurants=restaurantRepo.findAll();
		
		
		for(Restaurant r:restaurants)
		{
			List<Food> foods=foodController.getFoodByRestId(r.getRestId());
			r.setFoods(foods);
			
		}
		
		
		
		return restaurantRepo.findAll();
	}

	@Override
	public Restaurant restaurantUpdate(int restId, Restaurant restaurant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRestaurant(int restId) {
		// TODO Auto-generated method stub
		Restaurant restaurant=restaurantRepo.findById(restId).orElseThrow(() -> new ResourceNotFound(restId+"restId not found"));

		restaurantRepo.delete(restaurant);
	}

	@Override
	public Restaurant getById(int restId) {
		// TODO Auto-generated method stub
		
		Restaurant restaurant=restaurantRepo.findById(restId).orElseThrow(() -> new ResourceNotFound(restId+"restId not found"));
		return restaurant;
	}

}
