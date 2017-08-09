package com.tuber.service;

import java.util.List;

import com.tuber.domain.Customer;
import com.tuber.domain.Preference;

public interface CustomerService {
	List<Customer> getAllCustomer();
	Customer save(Customer customer);
	Boolean save( Preference preference);
	List<Preference> getAllPreferences();
	//Preference addPreference(Customer customer, Preference preference);
	void printData();
}
