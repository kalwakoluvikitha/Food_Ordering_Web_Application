package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.entity.User;
import com.example.repo.UserRepo;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFound(ResourceNotFound ex)
	{
		
		String message=ex.getMessage();
	   ApiResponse build=ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(build,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(UserAlreadyExist.class)
	public ResponseEntity<ApiResponse> handlerUserAlreadyExists(UserAlreadyExist ex)
	{

		String message=ex.getMessage();
	   ApiResponse build=ApiResponse.builder().message(message).success(true).status(HttpStatus.ALREADY_REPORTED).build();
		return new ResponseEntity<ApiResponse>(build,HttpStatus.ALREADY_REPORTED);
	}
	

}
