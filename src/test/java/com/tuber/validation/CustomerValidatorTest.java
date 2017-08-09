package com.tuber.validation;

import static org.junit.Assert.*;

import org.junit.Test;

import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.domain.Customer;

public class CustomerValidatorTest {

	@Test(expected = CustomerDoesNotExistException.class)
	public void shpuldThrowAnExceptionIfTheCustomerDoesntExist() throws CustomerDoesNotExistException {
		CustomerValidator.Validate(null);
	}
	
	@Test
	public void shpuldNotThrowAnExceptionIfTheCustomerExist() throws CustomerDoesNotExistException {
		CustomerValidator.Validate(new Customer("CustomerA"));
	}

}
