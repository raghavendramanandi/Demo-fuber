package com.tuber.Exceptions;

public class CustomerAlredyAssignedACabException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Customer is alredy riding";
	}
}
