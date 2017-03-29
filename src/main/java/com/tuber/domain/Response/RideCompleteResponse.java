package com.tuber.domain.Response;

import java.io.Serializable;

public class RideCompleteResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Double fair;

	public Double getFair() {
		return fair;
	}

	public void setFair(Double fair) {
		this.fair = fair;
	}

	public RideCompleteResponse(Double fair) {
		super();
		this.fair = fair;
	}

	public RideCompleteResponse() {
		super();
	}
	
	
	
}
