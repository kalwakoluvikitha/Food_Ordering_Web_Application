package com.example.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Model.User;



@FeignClient(name="USER-SERVICE/users")
public interface UserController {
	
	
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable int userId);

}
