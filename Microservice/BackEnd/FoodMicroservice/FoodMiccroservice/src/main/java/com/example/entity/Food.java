package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Food {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;
	
	private String foodName;
	
	private String foodType;
	
	private String category;
	
	private int restId;
	
	private Double price;
	
	@Column(columnDefinition="TEXT")
	private String image;	

}
