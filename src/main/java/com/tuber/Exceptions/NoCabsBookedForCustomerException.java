package com.tuber.Exceptions;

public class NoCabsBookedForCustomerException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "There is not booking for this customer";
	}
}
