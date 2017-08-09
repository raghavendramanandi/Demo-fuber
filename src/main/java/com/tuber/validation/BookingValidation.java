package com.tuber.validation;

import java.util.List;

import com.tuber.Exceptions.CustomerAlredyAssignedACabException;
import com.tuber.Exceptions.NoCabsBookedForCustomerException;
import com.tuber.domain.BookingData;

public class BookingValidation {

	public static void validate(List<BookingData> bookingData) throws CustomerAlredyAssignedACabException {
		if(bookingData.size()>0)
			throw new CustomerAlredyAssignedACabException();
	}

	public static void validateEndRide(List<BookingData> bookingData) throws NoCabsBookedForCustomerException {
		if(bookingData.size() == 0)
			throw new NoCabsBookedForCustomerException();
	}

}
