package com.tuber.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tuber.domain.Location;
import com.tuber.domain.Preference;
import com.tuber.service.CalculationService;

@Component("calculationService")
public class CalculationServiceImpl implements CalculationService{
	
	private final Double DogecoinPerMinute=1d;
	private final Double DogecoinPerKilometer = 2d;
	private final Double DogecoinForPinkCar = 5d;
	
	
	@Override
	public Double FairCalculator(int timeSpentInMinutes, Location endLocation, Location cabLastKnownLocation,
			List<Preference> customerPreferences) {
		
		return ((DogecoinPerMinute *timeSpentInMinutes)
				+ (DogecoinPerKilometer * endLocation.distance(cabLastKnownLocation.getLatitude(), cabLastKnownLocation.getLongitude())
			      + (customerPreferences.size() > 0 ? DogecoinForPinkCar : 0)));
	}
}
