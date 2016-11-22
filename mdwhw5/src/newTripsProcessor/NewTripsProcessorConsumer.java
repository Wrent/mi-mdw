package newTripsProcessor;

import jmsTools.JMSConsumer;
import model.Trip;

public class NewTripsProcessorConsumer extends JMSConsumer {

	@Override
	protected void processMessage(String msgText) throws Exception {
		NewTripsProcessor.addTrip(new Trip(msgText));
	}

}
