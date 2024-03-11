package com.example.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartIteam {
	
	
	
	private int  addtocartId;
	
	private int foodId;
	
	private String foodName;
	
	private Double price;
	
	private String image;	
	
	private int quantity;

}
