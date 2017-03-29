package com.tuber.service;

import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.Exceptions.InvalidLocationException;
import com.tuber.Exceptions.NoCabsAvailableException;
import com.tuber.domain.Location;

public interface BookingService {
	public Long BookCab(Long customerId,Location currentLocation) throws CustomerDoesNotExistException, NoCabsAvailableException, InvalidLocationException;
}
