package service;

import java.util.ArrayList;
import java.util.List;

import model.FlightBooking;

public class BookingsHandler {

	private static BookingsHandler inst = null;
	List<FlightBooking> bookings;
	int id = 0;
	
	public static BookingsHandler getInstance() {
		if (inst == null) {
			inst = new BookingsHandler();
		}
		return inst;
	}
	
	private BookingsHandler() {
		bookings = new ArrayList<>();
	}
	
	public List<FlightBooking> getBookings() {
		return bookings;
	}
	
	public int addBooking(String passenger, String dd, String ad, String d, String a) {
		FlightBooking booking = new FlightBooking(this.id++, passenger, dd, ad, d, a);
		bookings.add(booking);
		return booking.getId();
	}
	
	public boolean removeBooking(int id) {
		FlightBooking b = this.getFlightBookingWithId(id);
		if (b == null) {
			return false;
		}
		
		bookings.remove(b);
		return true;
	}
	
	public boolean updateBooking(int id, String passenger, String dd, String ad, String d, String a) {
		FlightBooking b = this.getFlightBookingWithId(id);
		if (b == null) {
			return false;
		}
		
		b.setPassengerName(passenger);
		b.setArrivalDate(ad);
		b.setArrivalAirport(a);
		b.setDepartureAirport(d);
		b.setDepartureDate(dd);
		return true;
	}
	
	private FlightBooking getFlightBookingWithId(int id) {
		for (FlightBooking b : bookings) {
			if (b.getId() == id) {
				return b;
			}
		}
		return null;
	}
}
