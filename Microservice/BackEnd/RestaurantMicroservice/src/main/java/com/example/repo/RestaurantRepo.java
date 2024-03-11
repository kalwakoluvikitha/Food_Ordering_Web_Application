package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant, Integer> {

}
