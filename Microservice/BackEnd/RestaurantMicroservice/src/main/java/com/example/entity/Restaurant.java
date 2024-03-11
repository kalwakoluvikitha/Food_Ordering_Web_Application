package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Food;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int restId;
	
	private String restName;
	
	private String location;

	
	private double rating ;
	
	
	@Column(columnDefinition="TEXT")
	private String image;	
	
	@Transient
	private List<Food> foods=new ArrayList<>();
}
