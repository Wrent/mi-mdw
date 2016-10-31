package rmi;

import database.Trip;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Client {

	public static void main(String[] args) throws Exception {
			HelloInterface server = (HelloInterface) Naming.lookup("//127.0.0.1/Hello");
			System.out.println(server.hello("John"));
	
			
			List<Trip> trips = server.get
	        for (Trip trip : trips) {
				System.out.println(trip);
	}

}
