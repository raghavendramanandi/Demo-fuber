package com.tuber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.Exceptions.InvalidLocationException;
import com.tuber.Exceptions.NoCabsBookedForCustomerException;
import com.tuber.dao.BookingDataRepository;
import com.tuber.dao.CabRepository;
import com.tuber.dao.CustomerRepository;
import com.tuber.dao.LocationRepository;
import com.tuber.dao.PreferenceRepository;
import com.tuber.domain.BookingData;
import com.tuber.domain.Cab;
import com.tuber.domain.Customer;
import com.tuber.domain.Request.EndRideRequest;
import com.tuber.domain.Response.RideCompleteResponse;
import com.tuber.service.CalculationService;
import com.tuber.service.RideService;
import com.tuber.validation.BookingValidation;
import com.tuber.validation.CustomerValidator;
import com.tuber.validation.LocationValidator;

@Component("rideService")
@Transactional
public class RideServiceImpl implements RideService{

	
	@Autowired
	CalculationService calculationService;
	
	private final CustomerRepository customerRepository;
	private final PreferenceRepository preferenceRepository;
	private final CabRepository cabRepository;
	private final BookingDataRepository bookingDataRepository;
	private final LocationRepository locationRepository;

	
	public RideServiceImpl(CustomerRepository customerRepository,
			PreferenceRepository preferenceRepository,
				CabRepository cabRepository,
					BookingDataRepository bookingDataRepository,
						LocationRepository locationRepository
			) {
		super();
		this.customerRepository = customerRepository;
		this.preferenceRepository = preferenceRepository;
		this.cabRepository = cabRepository;
		this.bookingDataRepository = bookingDataRepository;
		this.locationRepository = locationRepository;
	}
	
	@Override
	public RideCompleteResponse endRide(Long customerId, EndRideRequest endRideRequest) throws CustomerDoesNotExistException, InvalidLocationException, NoCabsBookedForCustomerException {
		Customer customer = customerRepository.findById(customerId);
		CustomerValidator.Validate(customer);
		LocationValidator.validate(endRideRequest.getEndLocation());
		BookingValidation.validateEndRide(bookingDataRepository.findByCustomer(customer));
		locationRepository.save(endRideRequest.getEndLocation());
		
		BookingData bookingData = bookingDataRepository.findByCustomer(customer).get(0);//assuming one cab will be assigned to one customer at any given time
		Cab cab = bookingData.getCab();
		
		Double fair = calculationService.FairCalculator(endRideRequest.getTimeSpentInMinutes(), endRideRequest.getEndLocation(), cab.getCabLastKnownLocation(), preferenceRepository.findByCustomer(customer));
		
		System.out.println("Booking data to delete"+bookingData);

		bookingDataRepository.delete(bookingData.getId());
		cab.setLocation(endRideRequest.getEndLocation());
		cabRepository.save(cab);
		
		return new RideCompleteResponse(fair);
	}
	
}
