package com.tuber.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class BookingData implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = false)
	private Customer customer;
	
	@ManyToOne(optional = false)
	private Cab cab;

	public BookingData(Customer customer, Cab cab) {
		super();
		this.customer = customer;
		this.cab = cab;
	}

	public BookingData() {
		super();
	}

	public Customer getCustomer() {
		return customer;
	}

	public Cab getCab() {
		return cab;
	}

	@Override
	public String toString() {
		return "BookingData [customer=" + customer + ", cab=" + cab + "]";
	}

	public Long getId() {
		return id;
	}
	
	
	
}
