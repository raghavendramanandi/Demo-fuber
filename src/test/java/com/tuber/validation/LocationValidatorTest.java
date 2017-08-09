package com.tuber.validation;

import org.junit.Test;

import com.tuber.Exceptions.InvalidLocationException;
import com.tuber.domain.Location;

public class LocationValidatorTest {

	@Test
	public void ShpuldNotThrowExceptionForValidLocation() throws InvalidLocationException {
		LocationValidator.validate(new Location(1.34545, 3.53252));
	}

}
