package database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Trip implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int capacity;
	private int id;
	//private List<String> reservations;
 
    public Trip(int id, int capacity, String name) {
		this.id = id;
        this.capacity = capacity;
        this.name = name;
        //this.reservations = new ArrayList<>();
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
    	return id;
    }

	@Override
	public String toString() {
		return "Trip id: "+ id +" to "+ name +", capacity "+ capacity +"\n";
	}
    
    
    
    /*public void addReservation(String person) {
    	this.reservations.add(person);
    }
    
    public List<String> getReservations() {
    	return reservations;
    }*/

}
