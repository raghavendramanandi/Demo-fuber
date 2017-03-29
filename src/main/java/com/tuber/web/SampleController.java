/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tuber.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuber.Exceptions.CustomerDoesNotExistException;
import com.tuber.Exceptions.NoCabsAvailableException;

import com.tuber.domain.Customer;

import com.tuber.domain.Location;
import com.tuber.domain.Preference;
import com.tuber.domain.RequestLocation;
import com.tuber.service.BookingService;

import com.tuber.service.CustomerService;

import com.tuber.service.LocationService;

@Controller
public class SampleController {

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/health-check")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
		System.out.println("I'm alive");
		return "I'm alive";
	}
	
	@PostMapping("/RequestCab/{customerId}")
	@ResponseBody
	@Transactional(readOnly = true)
	public String RequestCab(@PathVariable Long customerId, @RequestBody Location currentLocation) {
		try {
			System.out.println(customerId);
			System.out.println(currentLocation);
			bookingService.BookCab(customerId, currentLocation);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "";
	}
	
}
