package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.AddToCart;
import com.example.Model.CartIteam;
import com.example.Model.GroupByOrder;
import com.example.Model.Item;
import com.example.Model.Login;
import com.example.Model.Order;
import com.example.Model.PlacedOrders;
import com.example.entity.User;
import com.example.srvice.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.getAllUsers();
		System.out.println("excecuting");
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User user1 = userService.adduser(user);
		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);

	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		User user1 = userService.getById(userId);
		return new ResponseEntity<User>(user1, HttpStatus.ACCEPTED);

	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable int userId,@RequestBody User user)
	{
		
		User user1=userService.userUpdate(userId, user);
		return new ResponseEntity<User>(user1, HttpStatus.ACCEPTED);
		
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable int userId) {
		userService.deleteUser(userId);
		return (ResponseEntity<?>) ResponseEntity.ok();

	}

	@PostMapping("/addtocart/{userId}")
	public ResponseEntity<AddToCart> addAddToCart(@RequestBody AddToCart addToCart, @PathVariable int userId) {
		AddToCart addToCart2 = userService.addAddToCart(addToCart, userId);
System.out.println(addToCart2);
		return new ResponseEntity<AddToCart>(addToCart2, HttpStatus.ACCEPTED);
	}

//	@GetMapping("/addtocart")
//	public ResponseEntity<AddToCart> adAddToCart(@RequestBody AddToCart addToCart) {
//		AddToCart addToCart2 = userService.addAddToCart(addToCart);
//
//		return new ResponseEntity<AddToCart>(addToCart, HttpStatus.ACCEPTED);
//	}

	@PostMapping("/buynow/")
	public ResponseEntity<Order> buynow(@RequestBody Item item)

	{
		Order order = userService.buynow(item);

		return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
	}

	@PostMapping("/buyall/{userId}/{address}")
	public ResponseEntity<Order> byall(@PathVariable int userId, @PathVariable String address) {

		Order order = userService.byall(userId, address);
		return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
	}

//	@GetMapping("/login")
//	public ResponseEntity<User> loginuser(@RequestParam String email,
//			@RequestParam String password) {
//       System.out.println(password);
//		User user = userService.loginuser(email,password);
//		return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
//	}

	@PostMapping("/login")
	public ResponseEntity<User> loginuser(@RequestBody Login user) {
		System.out.println(user);
		User user1 = userService.loginuser(user.getEmail(), user.getPassword());

		System.out.println(user1);
		return new ResponseEntity<User>(user1, HttpStatus.ACCEPTED);
	}

	@GetMapping("/cartbyuserId/{userId}")
	public ResponseEntity<List<CartIteam>> atcartByUserId(@PathVariable int userId) {
		List<CartIteam> addToCarts = userService.atcartByUserId(userId);
		System.out.println(addToCarts + "mmm");
		return new ResponseEntity<List<CartIteam>>(addToCarts, HttpStatus.ACCEPTED);
	}

	@GetMapping("/increasequantity/{addtocartId}/{quantity}")
	public ResponseEntity<Integer> increaseQuantity(@PathVariable int addtocartId, @PathVariable int quantity)

	{
		int q = userService.increaseQuantity(addtocartId, quantity);
		return new ResponseEntity<Integer>(q, HttpStatus.ACCEPTED);
	}

	@GetMapping("/decreasequantity/{addtocartId}/{quantity}")
	public ResponseEntity<Integer> decreaseQuantity(@PathVariable int addtocartId, @PathVariable int quantity)

	{
		int q = userService.decreaseQuantity(addtocartId, quantity);
		return new ResponseEntity<Integer>(q, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deletecartiteam/{addtocartId}")
	public void deleteCartIteam(@PathVariable int addtocartId) {
		userService.deletecartIteam(addtocartId);

	}
	@GetMapping("/order/{userId}")
	public ResponseEntity<List<PlacedOrders>>  orderByUser(@PathVariable int userId)
	
	{
		List<PlacedOrders> orders=userService.orderByUser(userId);
		
		return new ResponseEntity<List<PlacedOrders>>(orders, HttpStatus.OK);  
		
	}
	
	@GetMapping("/gropubyorder/{userId}")
	public ResponseEntity<List<GroupByOrder>> grouporder(@PathVariable int userId)
	{
		
		
		List<GroupByOrder> groupByOrders=userService.grouporder(userId);
		return new ResponseEntity<List<GroupByOrder>>(groupByOrders
				, HttpStatus.OK);  
		
	}

}
