package com.tuber.validation;

import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.domain.Customer;

public class CustomerValidator {
	public static void Validate(Customer customer) throws CustomerDoesNotExistException{
		if(customer == null){
			throw new CustomerDoesNotExistException();
		}
	}
}
