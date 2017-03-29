package com.tuber.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.Exceptions.InvalidLocationException;
import com.tuber.Exceptions.NoCabsAvailableException;
import com.tuber.domain.BookingData;
import com.tuber.domain.COLOR;
import com.tuber.domain.Cab;
import com.tuber.domain.Customer;
import com.tuber.domain.Location;
import com.tuber.domain.Preference;
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
	public Long BookCab(Long customerId, Location currentLocation) throws CustomerDoesNotExistException, NoCabsAvailableException, InvalidLocationException {
		Customer customer = customerRepository.findById(customerId);
		CustomerValidator.Validate(customer);
		LocationValidator.validate(currentLocation);
		locationRepository.save(currentLocation);
		
		
		List<Cab> matchedCabs = getCabsForPreference(getCustomerPreferences(customer));
		/*System.out.println("===========================================");
		for (Cab cab : matchedCabs) {
			System.out.println(cab);
		}*/
		
		System.out.println();
		BookingData bookingData = bookingDataRepository.save(new BookingData(customer, findNearesCabForCustomer(currentLocation, matchedCabs)));
		return bookingData.getId();
	}

	

	// This method will get all available cabs based on preference
	private List<Cab> getCabsForPreference(List<Preference> customerPreferences) {
		List<Cab> availableCab =
		cabRepository.findByIdNotIn(
				bookingDataRepository.findAll().stream()
				 .map(BookingData::getCab)
				  .map(Cab::getId)
				  .collect(Collectors.toList()));
		if(customerPreferences.size() > 0){
			availableCab = availableCab.stream().filter(a -> customerPreferences.contains(a.getColor().name())).collect(Collectors.toList());
		}
		return availableCab;
	}

	private List<Preference> getCustomerPreferences(Customer customer) {
		List<Preference> customerPreferences = preferenceRepository.findByCustomer(customer);
		return customerPreferences;
	}

	private Cab findNearesCabForCustomer(Location currentLocation, List<Cab> matchedCabs) throws NoCabsAvailableException {
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
