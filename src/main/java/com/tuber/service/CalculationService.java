package com.tuber.service;

import java.util.List;

import com.tuber.domain.Location;
import com.tuber.domain.Preference;

public interface CalculationService {
	Double FairCalculator(int timeSpentInMinutes, Location endLocation, Location cabLastKnownLocation, List<Preference> customerPreferences);
}
