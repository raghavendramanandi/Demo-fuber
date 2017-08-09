package com.tuber.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LocationTest {

	@Test
	public void shouldCalculateTheDistanceWithLocation() {
		Location loc1 = new Location(1.234, 2.35125);
		assertEquals(62.60295032047841, loc1.distance(new Location(63.83218, 3.1240692)), 0);
	}
	
	@Test
	public void shouldCalculateTheDistanceWhenLatitudeAndLongitudeAreGiven() {
		Location loc1 = new Location(1.234, 2.35125);
		assertEquals(62.60295032047841, loc1.distance(63.83218, 3.1240692), 0);
	}

}
