package com.tuber.service;

import java.util.List;

import com.tuber.domain.Location;

public interface LocationService {
	List<Location> getLocation();

	void save(Location location);
}
