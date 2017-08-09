package com.tuber.Exceptions;

public class CustomerDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Customer is not registered with the system";
	}
}
