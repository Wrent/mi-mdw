package bookingsProcessor;

import java.util.ArrayList;
import java.util.List;

import jmsTools.JMSConsumer;
import model.Order;

public class BookingsProcessor {
	private static List<Order> bookings;
	
	public static void main(String[] args) throws Exception {
		String incomingQueueName = "bookingsQueue" ;
		bookings = new ArrayList<>();
	
		JMSConsumer consumer = new BookingsProcessorConsumer();
        consumer.receive(incomingQueueName);
	}
	
	public static void addBooking(Order booking) {
		bookings.add(booking);
		System.out.println("Booking added: "+ booking);
	}

}
