package rmi;

import database.Trip;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Random;

public class Client {

	public static void main(String[] args) throws Exception {
			TripsInterface server = (Server) Naming.lookup("//127.0.0.1/Trips");

			Random rn = new Random();
			Trip t = new Trip(rn.nextInt(), 313, "Canada");
	        server.addNewTrip(t);
	
			
			List<Trip> trips = server.getAllTrips();
	        for (Trip trip : trips) {
				System.out.println(trip);
	        }
	}

}
