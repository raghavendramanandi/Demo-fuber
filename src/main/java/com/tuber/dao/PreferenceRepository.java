package com.tuber.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import com.tuber.domain.Customer;

import com.tuber.domain.Preference;

public interface PreferenceRepository extends Repository<Preference	, Long> {
	List<Preference> findAll();
	
	Preference save(Preference preference);
	
	@Query("select p "
			+ "from Preference p where p.customer = ?1")
	List<Preference> findByCustomer(Customer customer);
}
