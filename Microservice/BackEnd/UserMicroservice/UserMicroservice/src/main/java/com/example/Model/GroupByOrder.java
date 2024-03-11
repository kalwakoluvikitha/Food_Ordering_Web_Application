package com.example.Model;


import java.util.Date;
import java.util.List;

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
public class GroupByOrder {
	
	int groupId;
	
	private List<PlacedOrders> placedOrders;
	
	private double orderAmount;
	
	private Date date;

}
