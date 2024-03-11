package com.example.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private int userId;
	
	
	private String userName;
	
	@Email
	private String email;
	
	private String password;
	
	
	private String address;
	
	private String phoneNo;
	
	


}
