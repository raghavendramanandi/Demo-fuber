package com.tuber.domain.Response;

import java.io.Serializable;

public class errorResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorMessage;
	
	public errorResponse(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public errorResponse() {
		super();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
