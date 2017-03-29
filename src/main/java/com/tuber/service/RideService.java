package com.tuber.service;

import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.Exceptions.InvalidLocationException;
import com.tuber.domain.Request.EndRideRequest;
import com.tuber.domain.Response.RideCompleteResponse;

public interface RideService {
	public RideCompleteResponse endRide(Long customerId, EndRideRequest endRideRequest	) throws CustomerDoesNotExistException, InvalidLocationException;
}
