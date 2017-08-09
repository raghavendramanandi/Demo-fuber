package com.tuber.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tuber.dao.LocationRepository;
import com.tuber.domain.Location;
import com.tuber.service.LocationService;


@Component("locationService")
@Transactional
public class LocationServiceImpl implements LocationService{
	private final LocationRepository locationRepository;

	public LocationServiceImpl(LocationRepository locationRepository) {
		super();
		this.locationRepository = locationRepository;
	}

	@Override
	public List<Location> getLocation() {
		return locationRepository.findAll();
	}

	@Override
	public void save(Location location) {
		locationRepository.save(location);
	}
	
}
