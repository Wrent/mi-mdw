package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import database.Trip;

public class Database {
	 	private static Connection conn = null;

	    public static void init(Connection conn) throws SQLException {
	    	Database.conn = conn;
	    	
	    	DatabaseMetaData dbmd = conn.getMetaData();
	        ResultSet rs = dbmd.getTables(null, null, "TRIPS", null);
	        if (rs.next()) {
	            System.out.println("Table " +  rs.getString(3) + " exists");
	        } else {
	            Statement stmt = conn.createStatement();
	            String query = "CREATE TABLE TRIPS (ID INT PRIMARY KEY, NAME VARCHAR(12), CAPACITY INT)";
	            stmt.executeUpdate(query);
	            stmt.close();
	 
	            stmt = conn.createStatement();
	            query = "INSERT INTO TRIPS VALUES (1,'Russia', 25),(2,'Rome',23),(3,'Svinny',18)";
	            stmt.executeUpdate(query);
	            stmt.close();
	        }
	    }
	    
	    public static void addTrip(Trip t) throws SQLException{
	    	Statement stmt = conn.createStatement();
	    	String query = "INSERT INTO TRIPS VALUES ("+t.getId()+",'"+t.getName()+"', "+t.getCapacity()+")";
            stmt.executeUpdate(query);
            stmt.close();
	    }
	    public static Trip getTrip(int id) throws SQLException {
	    	Statement stmt = conn.createStatement();
	        String query = "SELECT * FROM TRIPS WHERE ID = "+id;
	        ResultSet rs = stmt.executeQuery(query);
	        Trip t = null;
	        while (rs.next()) {
	            t = new Trip(rs.getInt("ID"), rs.getInt("CAPACITY"), rs.getString("NAME"));
	        }
	        stmt.close();
	        return t;
	    }
	    
	    public static List<Trip> getAllTrips() throws SQLException {
	    	Statement stmt = conn.createStatement();
	        String query = "SELECT * FROM TRIPS";
	        ResultSet rs = stmt.executeQuery(query);
	        ArrayList<Trip> trips = new ArrayList<>();
	        while (rs.next()) {
	            Trip t = new Trip(rs.getInt("ID"), rs.getInt("CAPACITY"), rs.getString("NAME"));
	            trips.add(t);
	        }
	        stmt.close();
	        return trips;
	    }
}
