package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import database.Trip;

public interface TripsInterface  extends Remote {

	public List<Trip> getAllTrips() throws RemoteException, SQLException;
	public void addNewTrip(Trip t) throws RemoteException, SQLException;
}
