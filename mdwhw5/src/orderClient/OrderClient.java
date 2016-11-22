package orderClient;

import java.util.ArrayList;
import java.util.List;

import jmsTools.JMSProducer;
import model.Order;
import model.OrderInterface;
import model.Trip;

public class OrderClient extends JMSProducer {

	public static void main(String[] args) throws Exception {
		String queueName = "allOrdersQueue" ;
		List<OrderInterface> list = new ArrayList<>();
		list.add(new Trip(1, "Brasil"));
		list.add(new Order(1, 1));
		list.add(new Order(2, 1));
		list.add(new Trip(2, "Canada"));
		list.add(new Order(3, 2));
		
        JMSProducer producer = new JMSProducer();
        for (OrderInterface o : list) {
        	producer.send(queueName, o.getMessage());
        }
	}

}
