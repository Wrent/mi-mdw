package wsdl;

import java.util.List;

import javax.jws.WebService;

import model.Trip;
import service.TripHandler;

@WebService
public class TripService {

	public List<String> getTrips() {
		TripHandler.getInstance();
		return TripHandler.getTrips();
	}
	
	public boolean addTrip(String name, int capacity) {
		TripHandler.getInstance();
		return TripHandler.addTrip(name, capacity);
	}
	
	public boolean makeReservation(String person, int trip) {
		TripHandler.getInstance();
		return TripHandler.makeReservation(person, trip);
	}
}
