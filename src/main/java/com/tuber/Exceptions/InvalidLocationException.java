package com.tuber.Exceptions;

public class InvalidLocationException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage(){
		return "Invalid location provided";
	}
}
