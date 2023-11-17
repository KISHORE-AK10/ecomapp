package com.cg.ecomapp.exception;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
