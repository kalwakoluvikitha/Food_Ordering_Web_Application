package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AddToCart;
import com.example.service.AddToCartService;



@RestController
@RequestMapping("/addtocart")
public class AddToCartController {
	
	
	
	@Autowired
	AddToCartService addToCartService;
	
	@GetMapping("/")
	public ResponseEntity<List<AddToCart>>   getAll()
	{
	     List<AddToCart> addToCarts=addToCartService.getAllAddToCarts();
		return  new ResponseEntity<List<AddToCart>>(addToCarts,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<AddToCart> addAddToCart(@RequestBody AddToCart addToCart)
	{
		AddToCart addToCart1=addToCartService.addaddtocart(addToCart);
		return new ResponseEntity<AddToCart>(addToCart1,HttpStatus.ACCEPTED);
		
		
	}
	
	@GetMapping("/{addToCartId}")
	public ResponseEntity<AddToCart> getAddToCartById(@PathVariable int addToCartId)
	{
		AddToCart addToCart1=addToCartService.getById(addToCartId);
		return new ResponseEntity<AddToCart>(addToCart1,HttpStatus.ACCEPTED);
		
		
	}
	
	@DeleteMapping("/{addToCartId}")
	public void deleteAddToCartById(@PathVariable int addToCartId)
	{
		addToCartService.deleteAddToCart(addToCartId);
		//return new ResponseEntity
		
		
	}
	
	
	@GetMapping("/cart/{cartId}")
	public ResponseEntity<List<AddToCart>> byCartId(@PathVariable int cartId)
	
	{
		List<AddToCart> addToCarts=addToCartService.getByCartId(cartId);
		return  new ResponseEntity<List<AddToCart>>(addToCarts,HttpStatus.OK);

	}
	
	 @GetMapping("/increasequantity/{addtocartId}/{quantity}")
	   public ResponseEntity<Integer> increaseQuantity(@PathVariable int addtocartId,@PathVariable int quantity)
	   
	   {
		 int q=addToCartService.increaseQuantity(addtocartId, quantity);
		 return new ResponseEntity<Integer>(q,HttpStatus.ACCEPTED);
	   }
	   
	   @GetMapping("/decreasequantity/{addtocartId}/{quantity}")
	   public ResponseEntity<Integer> decreaseQuantity(@PathVariable int addtocartId,@PathVariable int quantity)
	   
	   {
		 int q=addToCartService.decreaseQuantity(addtocartId, quantity);
		 return new ResponseEntity<Integer>(q,HttpStatus.ACCEPTED);
	   }
	   
	   @DeleteMapping("/carts/{cartId}")
		public void deleteAllByUserId(@PathVariable int cartId)
		{
			addToCartService.deleteAllByUserId(cartId);
			//return new ResponseEntity
			
			
		}
		

	
	

}
