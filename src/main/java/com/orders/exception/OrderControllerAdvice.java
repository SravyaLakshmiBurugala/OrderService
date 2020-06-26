package com.orders.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderControllerAdvice {
	
	@ExceptionHandler(OrderNotFound.class)
	public  ErrorMessage  exHandler(OrderNotFound  ex){
		ErrorMessage  em=new ErrorMessage();
		em.setCode(400);
		em.setMessage("order does not exist");
		return  em;
	}
	

}
