package com.example.Model;




import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlacedOrders {
	
	
	private int orderId;
	
	private String foodName;
	
	private int foodId;
	
	private int quantity;
	
	private double totalprice;
	
    private double orderAmount;
	
	private String billingAddress;

	private Date date;
	

}
