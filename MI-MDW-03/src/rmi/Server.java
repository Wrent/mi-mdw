package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;

import database.Database;
import database.Trip;

public class Server extends UnicastRemoteObject implements TripsInterface{
	public Server() throws RemoteException {
		super();
	}

	@Override
	public List<Trip> getAllTrips() throws RemoteException, SQLException {
		return Database.getAllTrips();
	}

	@Override
	public void addNewTrip(Trip t) throws RemoteException, SQLException {
		Database.addTrip(t);
	}

	
}
