package com.tuber.validation;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

import com.tuber.Exceptions.CustomerAlredyAssignedACabException;
import com.tuber.Exceptions.NoCabsBookedForCustomerException;
import com.tuber.domain.BookingData;
import com.tuber.domain.COLOR;
import com.tuber.domain.Cab;
import com.tuber.domain.Customer;
import com.tuber.domain.Location;

public class BookingValidationTest {

	@Test(expected = CustomerAlredyAssignedACabException.class)
	public void shouldThrowExceptionIfCustomerAlredyAssignedToACab() throws CustomerAlredyAssignedACabException {
		List<BookingData> booking = new ArrayList<BookingData>();
		booking.add(new BookingData(new Customer("CustA"), new Cab(COLOR.pink,"5355", new Location(1.11, 2.22))));
		BookingValidation.validate(booking);
	}
	
	@Test
	public void shouldNotThrowExceptionIfCustomerAlredyAssignedToACab() throws CustomerAlredyAssignedACabException {
		List<BookingData> booking = new ArrayList<BookingData>();
		BookingValidation.validate(booking);
	}
	
	@Test(expected = NoCabsBookedForCustomerException.class)
	public void shouldThrowExceprionIfCustomerTriesTOEndCabButNotRiding() throws NoCabsBookedForCustomerException {
		List<BookingData> booking = new ArrayList<BookingData>();
		BookingValidation.validateEndRide(booking);
	}
	
	@Test
	public void shouldNotThrowExceprionIfCustomerTriesTOEndCabWhenRiding() throws NoCabsBookedForCustomerException {
		List<BookingData> booking = new ArrayList<BookingData>();
		booking.add(new BookingData(new Customer("CustA"), new Cab(COLOR.pink,"5355", new Location(1.11, 2.22))));
		BookingValidation.validateEndRide(booking);
	}
}
