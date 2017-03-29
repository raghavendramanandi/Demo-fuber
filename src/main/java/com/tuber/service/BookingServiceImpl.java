package com.tuber.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.Exceptions.NoCabsAvailable;
import com.tuber.domain.Cab;
import com.tuber.domain.Customer;
import com.tuber.domain.Location;
import com.tuber.domain.Preference;

@Component("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService{

	private final CustomerRepository customerRepository;
	private final PreferenceRepository preferenceRepository;
	private final CabRepository cabRepository;

	public BookingServiceImpl(CustomerRepository customerRepository,
			PreferenceRepository preferenceRepository,
				CabRepository cabRepository
			) {
		super();
		this.customerRepository = customerRepository;
		this.preferenceRepository = preferenceRepository;
		this.cabRepository = cabRepository;
	}
	
	@Override
	public Long BookCab(Long customerId, Location currentLocation) throws CustomerDoesNotExistException, NoCabsAvailable {
		Customer customer = customerRepository.findById(customerId);
		if(customer == null){
			throw new CustomerDoesNotExistException();
		}
		List<Preference> customerPreferences = preferenceRepository.findByCustomer(customer);
		List<Cab> matchedCabs = cabRepository.findByColorIn(
				customerPreferences.stream()
					.map(Preference::getPreferenceValue)
						.collect(Collectors.toList()));
		findAllAvailableCabs(matchedCabs);
		findNearesCabForCustomer(currentLocation, matchedCabs);
		
		return 1L;
	}

	private List<Cab> findAllAvailableCabs(List<Cab> matchedCabs) {
		
		return null;
	}

	private Cab findNearesCabForCustomer(Location currentLocation, List<Cab> matchedCabs) throws NoCabsAvailable {
		double distance = 999999999;
		Cab selectedCab = null;
		for (Cab cab : matchedCabs) {
			if(currentLocation.distance(cab.getCabLastKnownLocation()) < distance){
				distance = currentLocation.distance(cab.getCabLastKnownLocation());
				selectedCab = cab;
			}
		}
		
		if(selectedCab  ==  null){
			throw new NoCabsAvailable();
		}
		return selectedCab;
	}
	
}
