package com.tuber.validation;

import com.tuber.Exceptions.InvalidLocationException;
import com.tuber.domain.Location;

public class LocationValidator {
	public static void validate(Location currentLocation) throws InvalidLocationException {
		if(currentLocation.getLatitude().isNaN() || currentLocation.getLongitude().isNaN() )
			throw new InvalidLocationException();
	}
}
