package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import java.util.List;



@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	
	
	User  findByEmailAndPassword(String email,String password);
	
	User  findByEmail(String email);
	
	User findByPhoneNo(String phoneNo);
	

}
