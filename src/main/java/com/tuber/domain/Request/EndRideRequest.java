package com.tuber.domain.Request;

import java.io.Serializable;

import com.tuber.domain.Location;

public class EndRideRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int timeSpentInMinutes;
	
	private Location endLocation;
	
	public int getTimeSpentInMinutes() {
		return timeSpentInMinutes;
	}

	public void setTimeSpentInMinutes(int timeSpentInMinutes) {
		this.timeSpentInMinutes = timeSpentInMinutes;
	}

	public Location getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}
	
	
}
