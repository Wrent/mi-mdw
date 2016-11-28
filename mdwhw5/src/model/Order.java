package model;

import java.util.List;

public class Order implements OrderInterface {

	private int id;
	private int trip_id;
	
	public Order(int id, int trip) {
		this.id = id;
		this.trip_id = trip;
	}
	
	public Order (String message) {
		if (message.toCharArray()[0] == 'o') {
			List<Integer> numbers = MessagesParser.parseMessage(message);
			this.id = numbers.get(0);
			this.trip_id = numbers.get(1);
		} else {
			return;
		}
	}
	
	public String getMessage() {
		return "order "+ id +" for trip "+ trip_id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", trip_id=" + trip_id + "]";
	}
	
	
}
