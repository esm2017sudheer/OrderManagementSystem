package com.example.exceptions;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}
