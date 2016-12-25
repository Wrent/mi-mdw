package travel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.Server;

public class Main {

	public static void main(String[] args) {
		Server server;
		try {
			server = new Server();

			LocateRegistry.createRegistry(1099);
			Naming.rebind("//0.0.0.0/Converter", server);
			System.out.println("...");
		} catch (RemoteException | MalformedURLException e) {
			System.err.println("Error while starting server");
			e.printStackTrace();
		}
	}

}
