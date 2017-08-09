package com.tuber.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tuber.dao.BookingDataRepository;
import com.tuber.dao.CabRepository;
import com.tuber.dao.CustomerRepository;
import com.tuber.dao.LocationRepository;
import com.tuber.dao.PreferenceRepository;
import com.tuber.domain.BookingData;
import com.tuber.domain.Cab;
import com.tuber.domain.Customer;
import com.tuber.domain.Preference;
import com.tuber.service.CustomerService;

@Component("customerService")
@Transactional
public class CustomerServiceImple implements CustomerService{
	private final CustomerRepository customerRepository;
	private final PreferenceRepository preferenceRepository;
	private final BookingDataRepository bookingDataRepository;
	private final CabRepository cabRepository;
	
	public CustomerServiceImple(CustomerRepository customerRepository
				, PreferenceRepository preferenceRepository
					, LocationRepository locationRepository
						, BookingDataRepository bookingDataRepository
							, CabRepository cabRepository) {
		super();
		this.customerRepository = customerRepository;
		this.preferenceRepository = preferenceRepository;
		this.bookingDataRepository = bookingDataRepository;
		this.cabRepository = cabRepository;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Boolean save(Preference preference) {
		preferenceRepository.save(preference);
		return true;
	}

	@Override
	public List<Preference> getAllPreferences() {
		return preferenceRepository.findAll();
	}

	@Override
	public void printData() {
		List<Customer> customers = customerRepository.findAll();
		List<Preference> preferences = preferenceRepository.findAll();
		List<Cab> cabs = cabRepository.findAll();
		List<BookingData> bookingDatas = bookingDataRepository.findAll();
		
		System.out.println("=======================customers==========================");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		
		System.out.println("=======================Preference==========================");
		for (Preference customer : preferences) {
			System.out.println(customer);
		}
		
		System.out.println("=======================cab==========================");
		for (Cab customer : cabs) {
			System.out.println(customer);
		}
		
		System.out.println("=======================Booking data==========================");
		for (BookingData customer : bookingDatas) {
			System.out.println(customer);
		}
		
	}
}
