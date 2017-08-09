package com.tuber.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tuber.Exceptions.CustomerAlredyAssignedACabException;
import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.Exceptions.InvalidLocationException;
import com.tuber.Exceptions.NoCabsAvailableException;
import com.tuber.dao.BookingDataRepository;
import com.tuber.dao.CabRepository;
import com.tuber.dao.CustomerRepository;
import com.tuber.dao.LocationRepository;
import com.tuber.dao.PreferenceRepository;
import com.tuber.domain.BookingData;
import com.tuber.domain.Cab;
import com.tuber.domain.Customer;
import com.tuber.domain.Location;
import com.tuber.domain.Preference;
import com.tuber.service.BookingService;
import com.tuber.validation.BookingValidation;
import com.tuber.validation.CustomerValidator;
import com.tuber.validation.LocationValidator;

@Component("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService{

	private final CustomerRepository customerRepository;
	private final PreferenceRepository preferenceRepository;
	private final CabRepository cabRepository;
	private final BookingDataRepository bookingDataRepository;
	private final LocationRepository locationRepository;

	
	public BookingServiceImpl(CustomerRepository customerRepository,
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
	public Long BookCab(Long customerId, Location currentLocation) throws CustomerDoesNotExistException, NoCabsAvailableException, InvalidLocationException, CustomerAlredyAssignedACabException {
		Customer customer = customerRepository.findById(customerId);
		CustomerValidator.Validate(customer);
		LocationValidator.validate(currentLocation);
		BookingValidation.validate(bookingDataRepository.findByCustomer(customer));
		locationRepository.save(currentLocation);
		
		List<Cab> matchedCabs = getCabsForPreference(getCustomerPreferences(customer));
		
		System.out.println();
		BookingData bookingData = bookingDataRepository.save(new BookingData(customer, findNearesCabForCustomer(currentLocation, matchedCabs)));
		return bookingData.getId();
	}

	

	// This method will get all available cabs based on preference
	private List<Cab> getCabsForPreference(List<Preference> customerPreferences) {
		List<Long> collect = bookingDataRepository.findAll().stream()
		 .map(BookingData::getCab)
		  .map(Cab::getId)
		  .collect(Collectors.toList());
		collect.add(-1l);
		List<Cab> availableCab =cabRepository.findByIdNotIn(collect);
		
		if(customerPreferences.size() > 0){
			availableCab = availableCab.stream().filter(a -> customerPreferences.contains(a.getColor().name())).collect(Collectors.toList());
		}
		return availableCab;
	}

	private List<Preference> getCustomerPreferences(Customer customer) {
		List<Preference> customerPreferences = preferenceRepository.findByCustomer(customer);
		return customerPreferences;
	}

	public Cab findNearesCabForCustomer(Location currentLocation, List<Cab> matchedCabs) throws NoCabsAvailableException {
		double distance;
		double minDistance = 999999999;
		Cab selectedCab = null;
		for (Cab cab : matchedCabs) {
			distance = cab.getCabLastKnownLocation().distance(currentLocation);
			if(distance < minDistance){
				minDistance = distance;
				selectedCab = cab;
			}
		}
		
		if(selectedCab  ==  null){
			throw new NoCabsAvailableException();
		}
		return selectedCab;
	}
	
}
