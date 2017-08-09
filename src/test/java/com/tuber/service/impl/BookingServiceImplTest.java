package com.tuber.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tuber.Exceptions.NoCabsAvailableException;
import com.tuber.domain.COLOR;
import com.tuber.domain.Cab;
import com.tuber.domain.Location;
import com.tuber.service.BookingService;

public class BookingServiceImplTest {

	@Autowired
	BookingService bookingService;
	
	@Test
	public void shouldFindTheNearestCab() throws NoCabsAvailableException {
		List<Cab> matchedCabs = new ArrayList<Cab>();
		matchedCabs.add(new Cab(null, "1", new Location(1d,1d)));
		matchedCabs.add(new Cab(null, "2", new Location(2d,2d)));
		matchedCabs.add(new Cab(null, "3", new Location(3d,3d)));
		matchedCabs.add(new Cab(null, "4", new Location(4d,4d)));
		Cab cab = bookingService.findNearesCabForCustomer(new Location(0d,0d), matchedCabs);
		
		assertEquals(cab.getRegisterationNumber(), "1");
		
	}

}
