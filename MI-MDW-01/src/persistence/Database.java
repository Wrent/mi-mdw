package persistence;

import java.util.Hashtable;
import java.util.Set;

public class Database {
	 private static Database instance = null;
	    private Hashtable<Integer, Trip> ht = new Hashtable();
	 
	    public static Database getInstance() {
	        if (instance == null)
	            instance = new Database();
	        return instance;
	    }
	    public void addObject(Trip t){
	        ht.put(t.getId(), t);
	    }
	    public Trip getObject(int id) {
	        return ht.get(id);
	    }
	    
	    public Set<Integer> getIds() {
	    	return ht.keySet();
	    }
}
