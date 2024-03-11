package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Restaurant {
	
	
   private int restId;
	
	private String restName;
	
	private String location;

	
	private double rating ;
	
	
//	
//	private String image;	
//	
//	
//	private List<Food> foods=new ArrayList<>();

}
