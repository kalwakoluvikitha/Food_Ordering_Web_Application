package com.example.Model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Order {
	
	
	
private int orderId;
	
	
	private String orderStatus;
	
	
	private String payamentStatus;
	
	private double orderAmount;
	
	private String billingAddress;
	
	private int userId;
	
	private List<OrderItem> orderItems;
	
	private Date date;

}
