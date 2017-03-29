package com.tuber.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cab implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private COLOR color;
	
	@Column(nullable = false)
	private String RegisterationNumber;

	@OneToOne(fetch = FetchType.LAZY)
	private Location location;

	public Cab() {
		super();
	}

	public Cab(COLOR color, String registerationNumber, Location cabLastKnownLocation) {
		super();
		this.color = color;
		RegisterationNumber = registerationNumber;
		this.location = cabLastKnownLocation;
	}

	public COLOR getColor() {
		return color;
	}

	public String getRegisterationNumber() {
		return RegisterationNumber;
	}

	public Location getCabLastKnownLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Cab [color=" + color + ", RegisterationNumber=" + RegisterationNumber + ", cabLastKnownLocation="
				+ location + "]";
	}
	
	
	
}
