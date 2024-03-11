package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.OrderItem;

public interface OrderItemRepo    extends  JpaRepository<OrderItem, Integer>{
	
	
	
	
	List<OrderItem> findByOrderId(int orderId);

}
