package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote {

	public String hello(String name) throws RemoteException;
	
}
