package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFound;
import com.example.entity.AddToCart;
import com.example.feign.FoodController;
import com.example.model.Food;
import com.example.repo.AddToCartRepo;
import com.example.service.AddToCartService;


@Service
public class AddToCartServiceImpl implements AddToCartService {

	
	@Autowired
	AddToCartRepo addToCartRepo;
	
	@Autowired
	FoodController foodController;
	
	
	@Override
	public AddToCart addaddtocart(AddToCart addtocart) {
		// TODO Auto-generated method stub
		
		
		AddToCart addToCart2=addToCartRepo.findByFoodIdAndCartId(addtocart.getFoodId(), addtocart.getCartId());
		
		AddToCart addToCart3=new AddToCart();
		Food food=foodController.getFoodById(addtocart.getFoodId());
		
		if(addToCart2!=null)
		{
			
			addToCart2.setQuantity(addToCart2.getQuantity()+1);
			addToCart2.setPrice(food.getPrice());
			addToCartRepo.save(addToCart2);
		        
			
			addToCart3=addToCart2;
		
			System.out.println(addToCart3);
		}
		else {
		
		
		//addtocart.setCartId(addtocart.getCartId());
		addtocart.setPrice(food.getPrice());
		
		addtocart.setPrice(addtocart.getQuantity()*food.getPrice());
		
		addToCart3= addToCartRepo.save(addtocart);
		}
		
		System.out.println(addToCart3);
		
		return addToCart3;
		
		
	}

	@Override
	public List<AddToCart> getAllAddToCarts() {
		// TODO Auto-generated method stub
		return addToCartRepo.findAll();
	}

	@Override
	public AddToCart addtocartUpdate(int addtocartId, AddToCart addtocart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAddToCart(int addtocartId) {
		// TODO Auto-generated method stub
		AddToCart addToCart=addToCartRepo.findById(addtocartId).orElseThrow(()-> new ResourceNotFound(addtocartId+"id not found"));
addToCartRepo.delete(addToCart);
	}

	@Override
	public AddToCart getById(int addtocartId) {
		// TODO Auto-generated method stub
		
		AddToCart addToCart=addToCartRepo.findById(addtocartId).orElseThrow(()-> new ResourceNotFound(addtocartId+"id not found"));

		
		return addToCart;
	}

	@Override
	public List<AddToCart> getByCartId(int cartId) {
		// TODO Auto-generated method stub
		return addToCartRepo.findBycartId(cartId);
	}

	@Override
	public int increaseQuantity(int addtocartId, int quantity) {
		// TODO Auto-generated method stub
		
		AddToCart addToCart=addToCartRepo.findById(addtocartId).orElseThrow(()-> new ResourceNotFound(addtocartId+"id not found"));
        int q=quantity+1; 
		addToCart.setQuantity(q);
		  addToCartRepo.save(addToCart);
		return q;
	}

	@Override
	public int decreaseQuantity(int addtocartId, int quantity) {
		// TODO Auto-generated method stub
		
		AddToCart addToCart=addToCartRepo.findById(addtocartId).orElseThrow(()-> new ResourceNotFound(addtocartId+"id not found"));
         int q=quantity-1;
		addToCart.setQuantity(q);
          addToCartRepo.save(addToCart);
          
		return q;
	}

	@Override
	public void deleteAllByUserId(int cartId) {
		// TODO Auto-generated method stub
	
		List<AddToCart> addToCarts=addToCartRepo.findBycartId(cartId);
		
		for(AddToCart a:addToCarts)
		{
			addToCartRepo.deleteById(a.getAddtocartId());
		}
		
		
	}

}
