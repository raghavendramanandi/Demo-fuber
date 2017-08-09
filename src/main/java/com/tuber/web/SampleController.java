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

import com.tuber.domain.Location;
import com.tuber.domain.Request.EndRideRequest;
import com.tuber.domain.Response.errorResponse;
import com.tuber.service.BookingService;
import com.tuber.service.CustomerService;
import com.tuber.service.RideService;

@Controller
public class SampleController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	RideService rideService;

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
	public Object requestCab(@PathVariable Long customerId, @RequestBody Location currentLocation) {
		try {
			System.out.println(customerId);
			System.out.println(currentLocation);
			bookingService.BookCab(customerId, currentLocation);
		} catch (Exception e) {
			e.printStackTrace();
			return new errorResponse(611, e.getMessage());
		}
		return "";
	}

	@PostMapping("/endRide/{customerId}")
	@ResponseBody
	@Transactional(readOnly = true)
	public Object endRide(@PathVariable Long customerId, @RequestBody EndRideRequest endRide) {
		try {
			System.out.println(customerId);
			return rideService.endRide(customerId, endRide);
		} catch (Exception e) {
			e.printStackTrace();
			return new errorResponse(610, e.getMessage());
		}
	}

	@GetMapping("/printdata")
	@ResponseBody
	@Transactional(readOnly = true)
	public void printData() {
		customerService.printData();
	}
}
