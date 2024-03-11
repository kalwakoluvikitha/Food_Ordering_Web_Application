package com.example.entity;


import java.util.Date;
import java.util.List;

import com.example.Model.OrderItem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	
	private String orderStatus;
	
	
	private String payamentStatus;
	
	private double orderAmount;
	
	private String billingAddress;
	
	private int userId;
	
	private Date date;
	
	@Transient
	private List<OrderItem> orderItems;
	
	
	
	

}
