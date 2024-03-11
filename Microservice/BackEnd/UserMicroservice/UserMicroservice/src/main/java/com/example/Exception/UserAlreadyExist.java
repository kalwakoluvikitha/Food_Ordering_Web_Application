package com.example.Exception;

public class UserAlreadyExist extends RuntimeException {

	public UserAlreadyExist() {
		super("user already exists");
		// TODO Auto-generated constructor stub
	}

	public UserAlreadyExist(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
