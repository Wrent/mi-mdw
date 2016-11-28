package model;

import java.util.List;

public class Trip implements OrderInterface {

	private int id;
	private String loc;
	
	public Trip(int id, String loc) {
		this.id = id;
		this.loc = loc;
	}
	
	public Trip (String message) {
		if (message.toCharArray()[0] == 't') {
			List<Integer> numbers = MessagesParser.parseMessage(message);
			this.id = numbers.get(0);
			this.loc = message.substring(message.lastIndexOf(" ")+1);
		} else {
			return;
		}
	}
	
	public String getMessage() {
		return "trip "+ id +" to "+ loc;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", loc=" + loc + "]";
	}
}
