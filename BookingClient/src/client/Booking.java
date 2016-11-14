package client;

public class Booking {
	private int id;

	public Booking(int id) {
		super();
		this.id = id;
	}
	
	public String getMessage() {
		return "booking " + id; 
	}
	
	public void confirm() {
        System.out.println("Booking number "+id+" completed!");
	}
}
