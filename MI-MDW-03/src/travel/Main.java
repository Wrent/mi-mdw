package travel;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

import database.Database;
import database.Trip;
import rmi.Server;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver).newInstance();
        String protocol = "jdbc:derby:";
        Connection conn = DriverManager.getConnection(protocol + "derbyDB;create=true");
        Database.init(conn);
       
        Server server = new Server();
		
		LocateRegistry.createRegistry(1099);
		Naming.rebind("//0.0.0.0/Trips", server);
		System.out.println("...");
        
        /*Random rn = new Random();
        Trip t = new Trip(rn.nextInt(), 313, "Canada");
        Database.addTrip(t);
        
        t = Database.getTrip(1);    
        System.out.println(t);
        
        List<Trip> trips = Database.getAllTrips();
        for (Trip trip : trips) {
			System.out.println(trip);
		}*/
    }
 
}

