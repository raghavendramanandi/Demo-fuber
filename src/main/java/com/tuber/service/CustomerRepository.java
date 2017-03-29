package com.tuber.service;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.tuber.domain.Customer;

public interface CustomerRepository extends Repository<Customer, Long>{
	List<Customer> findAll();
	Customer findById(Long id);
	Customer save(Customer customer);
}
