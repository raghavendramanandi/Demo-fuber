package com.tuber.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Preference implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	private Customer customer;

	
	@Column(nullable = false)
	private String preferenceValue;

	protected Preference() {
	}

	public Preference(String prefer, Customer cust) {
		this.preferenceValue = prefer;
		customer = cust;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPreferenceValue() {
		return preferenceValue;
	}

	public void setPreferenceValue(String preferenceValue) {
		this.preferenceValue = preferenceValue;
	}

	@Override
	public String toString() {
		return "Preference [id=" + id + ", customer=" + customer + ", preferenceValue=" + preferenceValue + "]";
	}
}
