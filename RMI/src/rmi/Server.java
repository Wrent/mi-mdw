package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements HelloInterface {

	protected Server() throws RemoteException {
		super();
	}

	@Override
	public String hello(String name) throws RemoteException {
		return "Hello "+name;
	}

}
