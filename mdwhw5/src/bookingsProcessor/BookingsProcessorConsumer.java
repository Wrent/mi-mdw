package bookingsProcessor;

import jmsTools.JMSConsumer;
import model.Order;

public class BookingsProcessorConsumer extends JMSConsumer {

	@Override
	protected void processMessage(String msgText) throws Exception {
		BookingsProcessor.addBooking(new Order(msgText));
	}

}
