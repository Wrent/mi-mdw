package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trip{

	private String name;
	private int capacity;
	private int no;
	private List<String> bookings;
 
	public Trip () {
		this.no = 0;
		this.capacity = 0;
		this.name = "";
		this.bookings = new ArrayList<>();
	}
	
    public Trip(int id, int capacity, String name) {
    	this.no = id;
        this.capacity = capacity;
        this.name = name;
        this.bookings = new ArrayList<>();
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public int getCapacity() {
        return capacity; //- reservations.size();
    }
 
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public int getId() {
    	return no;
    }

	@Override
	public String toString() {
		return "Trip id: "+ no +" to "+ name +", capacity "+ capacity +", bookings: "+ bookings +"\n";
	}
    
    public void addBooking(String person) {
    	this.bookings.add(person);
    }
    
    public List<String> getBookings() {
    	return bookings;
    }

}
