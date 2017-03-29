package com.tuber.domain;

import javax.persistence.Column;

public class RequestLocation {
	
	private Double latitude;

	private Double longitude;

	public RequestLocation(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	
	public RequestLocation() {
		super();
	}


	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	
}
