package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Registry {

	public static void main(String[] args) {
		try {
			Server server = new Server();
			
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//0.0.0.0/Hello", server);
			System.out.println("...");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
