package orderProcessor;

import jmsTools.JMSConsumer;

public class OrderProcessor {

	public static void main(String[] args) throws Exception {
		String incomingQueueName = "allOrdersQueue" ;
	
		JMSConsumer consumer = new OrderProcessorConsumer();
        consumer.receive(incomingQueueName);
	}
}
