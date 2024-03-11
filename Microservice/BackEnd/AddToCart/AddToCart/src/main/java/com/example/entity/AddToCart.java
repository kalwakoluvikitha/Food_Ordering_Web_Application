package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddToCart {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int  addtocartId;
	
	
	private int foodId;
	
	private int cartId;
	
	private int quantity;
	
	private double price;
	
	
	
	
	
	
	
	
}
