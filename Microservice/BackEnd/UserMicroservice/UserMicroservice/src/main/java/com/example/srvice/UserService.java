package com.example.srvice;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Model.AddToCart;
import com.example.Model.CartIteam;
import com.example.Model.GroupByOrder;
import com.example.Model.Item;
import com.example.Model.Order;
import com.example.Model.PlacedOrders;
import com.example.entity.User;



@Service
public interface UserService {
	
	

	User adduser(User  user);
	
	
	List<User>  getAllUsers();
	
	
	User userUpdate(int userId,User user);
	
	void deleteUser(int userId);
	
	
	User getById(int userId);
	
	
	AddToCart addAddToCart( AddToCart addToCart,int userId);


	Order buynow(Item item);


	Order byall(int userId,String address);


	User loginuser(String email, String password);


	List<CartIteam> atcartByUserId(int userId);


	int increaseQuantity(int addtocartId, int quantity);


	int decreaseQuantity(int addtocartId, int quantity);


	void deletecartIteam(int addtocartId);


	List<PlacedOrders> orderByUser(int userId);
	
	
	public List<GroupByOrder> grouporder(int userId);
}
