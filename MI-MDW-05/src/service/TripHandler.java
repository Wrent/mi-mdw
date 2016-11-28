package service;

import java.util.ArrayList;
import java.util.List;

import model.Trip;

public class TripHandler {

	private static List<Trip> trips;
	private static int id;
	private static TripHandler inst = null;

	public static TripHandler getInstance() {
		if (inst == null) {
			inst = new TripHandler();
		}
		return inst;
	}
	
	private TripHandler() {
		super();
		id = 0;
		trips = new ArrayList<>();
	}
	
	public static List<String> getTrips() {
		List<String> arr = new ArrayList<>();
		for (Trip t : trips) {
			arr.add(t.toString());
		}
		return arr;
	}
	
	public static boolean addTrip(String name, int capacity) {
		for (Trip t : trips) {
			if (t.getName().equals(name)) {
				return false;
			}
		}
		Trip t = new Trip(id++, capacity, name);
		trips.add(t);
		return true;
	}
	
	public static boolean makeReservation(String person, int trip) {
		Trip bookedTrip = null;
		for (Trip t : trips) {
			if (t.getId() == trip) {
				bookedTrip = t;
				break;
			}
		}
		if (bookedTrip == null) {
			return false;
		}
		if (bookedTrip.getBookings().size() < bookedTrip.getCapacity()) {
			bookedTrip.addBooking(person);
			return true;
		} else {
			return false;
		}
	}
	
	
}
