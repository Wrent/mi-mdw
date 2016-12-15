package model;


public class FlightBooking {
	private int id;
	private String passengerName;
	private String departureDate;
	private String arrivalDate;
	private String departureAirport;
	private String arrivalAirport;
	
	public FlightBooking () {
		super();
		this.id = -1;
		this.passengerName = null;
		this.departureDate = null;
		this.arrivalDate = null;
		this.departureAirport = null;
		this.arrivalAirport = null;
	}
	
	public FlightBooking(int id, String passengerName, String departureDate, String arrivalDate, String departureAirport,
			String arrivalAirport) {
		super();
		this.id = id;
		this.passengerName = passengerName;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}
	
	

}
