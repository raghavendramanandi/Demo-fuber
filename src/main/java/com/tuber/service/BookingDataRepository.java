package com.tuber.service;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.tuber.domain.BookingData;
import com.tuber.domain.Cab;
import com.tuber.domain.Customer;

public interface BookingDataRepository extends Repository<BookingData, Long>{
	BookingData save(BookingData bookingData);
	
	List<BookingData> findByCustomer(Customer customer);
	
	List<BookingData> findByCab(Cab cab);
	
	List<BookingData> findAll();
}
