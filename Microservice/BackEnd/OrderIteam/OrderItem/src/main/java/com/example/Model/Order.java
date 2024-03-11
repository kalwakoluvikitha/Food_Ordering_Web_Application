package com.example.Model;

import java.util.Date;
import java.util.List;



import com.example.entity.OrderItem;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Order {
private int orderId;
	
	
	private String orderStatus;
	
	
	private String payamentStatus;
	
	private double orderAmount;
	
	private String billingAddress;
	
	private int userId;
	
	private Date date;
	
	private List<OrderItem> orderItems;
	
}
