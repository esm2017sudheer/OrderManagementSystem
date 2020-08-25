package com.example.exceptions;

public class OrderItemNotFoundException extends RuntimeException {

	public OrderItemNotFoundException(String errorMsg) {
		super(errorMsg);
	}
	
}
