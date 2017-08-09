package com.tuber.service;

import java.util.List;

import com.tuber.Exceptions.CustomerAlredyAssignedACabException;
import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.Exceptions.InvalidLocationException;
import com.tuber.Exceptions.NoCabsAvailableException;
import com.tuber.domain.Cab;
import com.tuber.domain.Location;

public interface BookingService {
	public Long BookCab(Long customerId,Location currentLocation) throws CustomerDoesNotExistException, NoCabsAvailableException, InvalidLocationException, CustomerAlredyAssignedACabException;
	public Cab findNearesCabForCustomer(Location currentLocation, List<Cab> matchedCabs) throws NoCabsAvailableException;
}
