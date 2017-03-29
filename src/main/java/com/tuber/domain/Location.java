package com.tuber.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Location implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private Double latitude;

	@Column(nullable = false)
	private Double longitude;

	public Location(Double latitude, Double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	public Double distance(Location location) {
		//Distance =(x2−x1)2+(y2−y1)2‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾√
		System.out.println(this.latitude);
		System.out.println(this.longitude);
		System.out.println(location.latitude);
		System.out.println(location.longitude);
		return Math.sqrt(
				Math.pow((this.latitude - location.latitude), 2) +
				Math.pow((this.longitude - location.longitude), 2));		 
	}

}
