package com.tuber.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tuber.domain.BookingData;
import com.tuber.domain.COLOR;
import com.tuber.domain.Cab;
import com.tuber.domain.Customer;
import com.tuber.domain.CustomerPreference;
import com.tuber.domain.Location;
import com.tuber.domain.Preference;

@Component("customerService")
@Transactional
public class CustomerServiceImple implements CustomerService{
	private final CustomerRepository customerRepository;
	private final PreferenceRepository preferenceRepository;
	private final LocationRepository locationRepository;
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
		this.locationRepository = locationRepository;
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
	public void test() {
		
		/*System.out.println("====================================================================");
		for (Customer cus : customerRepository.findAll()) {
			System.out.println(cus);
		}
		
		for (Preference cus : preferenceRepository.findAll()) {
			System.out.println(cus);
		}
		System.out.println("====================================================================");
		
		
		
		Customer customer = new Customer("Aditya");
		customerRepository.save(customer);
		System.out.println("Customer saved");
		List<Customer> customers = customerRepository.findAll();
		for (Customer customer2 : customers) {
			System.out.println(customer2);
		}
		
		
		Preference preference = new Preference("pink",customers.get(0));
		preferenceRepository.save(preference);
		
		
		List<Preference> preferences = preferenceRepository.findAll();
		for (Preference preference2 : preferences) {
			System.out.println(preference2);
		}
		System.out.println("Customer is: ");
		System.out.println(customerRepository.findAll().get(0));
		
		System.out.println("=======================test .2==========================");
		
		List<Preference> preName = preferenceRepository.findByCustomer(customers.get(0));
		for (Preference s : preName) {
			System.out.println(s.getPreferenceValue());
		}*/
		Location location = new Location(1111.0, 11111.0);
		Location savedLocation = locationRepository.save(location);
		Cab cab1 = new Cab(COLOR.pink, "1234", savedLocation);
		cabRepository.save(cab1);
		/*System.out.println("Booking data:");
		System.out.println(bookingDataRepository.save(new BookingData(customer, cabRepository.save(cab1))));
		
		customer.setName("Aditya1");
		customerRepository.save(customer);
		
		System.out.println(bookingDataRepository.findAll().get(0));
*/
		for (Cab cab : cabRepository.findAll()) {
			System.out.println(cab);
		}
		System.out.println(customerRepository.findAll().get(0));
	}
	
}
