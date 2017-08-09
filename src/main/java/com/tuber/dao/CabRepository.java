package com.tuber.dao;

import java.util.List;
import org.springframework.data.repository.Repository;

import com.tuber.domain.Cab;

public interface CabRepository extends Repository<Cab, Long>{
	Cab save(Cab cab);
	
	List<Cab> findByColorIn(List<String> colours);
	
	Cab findById(Long id);
	
	List<Cab> findAll();
	
	List<Cab> findByIdNotIn(List<Long> bookedCars);
}
