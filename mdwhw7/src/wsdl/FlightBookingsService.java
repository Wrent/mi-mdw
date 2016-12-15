package wsdl;

import java.util.List;

import javax.jws.WebService;

import model.FlightBooking;
import service.BookingsHandler;

@WebService
public class FlightBookingsService {

	public List<FlightBooking> getBookings() {
		BookingsHandler handler = BookingsHandler.getInstance();
		return handler.getBookings();
	}

	
	public int addBooking(String passenger, String dd, String ad, String d, String a) {
		BookingsHandler handler = BookingsHandler.getInstance();
		return handler.addBooking(passenger, dd, ad, d, a);
	}
	
	public boolean removeBooking(int id) {
		BookingsHandler handler = BookingsHandler.getInstance();
		return handler.removeBooking(id);
	}
	
	public boolean updateBooking(int id, String passenger, String dd, String ad, String d, String a) {
		BookingsHandler handler = BookingsHandler.getInstance();
		return handler.updateBooking(id, passenger, dd, ad, d, a);
	}
}
