package com.tuber.Exceptions;

public class NoCabsAvailableException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Cabs are not available at this time";
	}
}
