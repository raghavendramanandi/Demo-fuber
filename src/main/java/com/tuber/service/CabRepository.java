package com.tuber.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.tuber.domain.Cab;

public interface CabRepository extends Repository<Cab, Long>{
	Cab save(Cab cab);
	
	List<Cab> findByColorIn(List<String> colours);
	
	Cab findById(Long id);
	
	List<Cab> findAll();
	
	//@Query("select c.id from Cab c where c.id not in (select bd.cab from BookingData bd)")
	List<Cab> findByIdNotIn(List<Long> bookedCars);
}
