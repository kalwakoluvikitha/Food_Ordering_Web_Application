package com.example.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderItem {

	private int orderIteamId;

	private int foodId;

	private double totalprice;

	private int quantity;

	private int orderId;

}
