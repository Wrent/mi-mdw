package jmsTools;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSProducer {
	 
    // connection factory
        private QueueConnectionFactory qconFactory;
 
        // connection to a queue
        private QueueConnection qcon;
 
        // session within a connection
        private QueueSession qsession;
 
        // queue sender that sends a message to the queue
        private QueueSender qsender;
 
        // queue where the message will be sent to
        private Queue queue;
 
        // a message that will be sent to the queue
        private TextMessage msg;
        
        // create a connection to the WLS using a JNDI context
        public void init(Context ctx, String queueName)
            throws NamingException, JMSException {
 
            // create connection factory based on JNDI and a connection
            qconFactory = (QueueConnectionFactory) ctx.lookup(Config.JMS_FACTORY);
            qcon = qconFactory.createQueueConnection();
 
            // create a session within a connection
            qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
 
            // lookups the queue using the JNDI context
            queue = (Queue) ctx.lookup(queueName);
 
            // create sender and message
            qsender = qsession.createSender(queue);
            msg = qsession.createTextMessage();
        }
 
        // close sender, connection and the session
        public void close() throws JMSException {
            qsender.close();
            qsession.close();
            qcon.close();
        }
 
        // sends the message to the queue
        public void send(String queueName, String message) throws Exception {
 
            // create a JNDI context to lookup JNDI objects (connection factory and queue)
            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY, Config.JNDI_FACTORY);
            env.put(Context.PROVIDER_URL, Config.PROVIDER_URL);
 
            InitialContext ic = new InitialContext(env);
            init(ic, queueName);
 
            // send the message and close
            try {
                msg.setText(message);
                qsender.send(msg, DeliveryMode.PERSISTENT, 8, 0);
                System.out.println("The message was sent to the destination " +
                        qsender.getDestination().toString());
            } finally {
                close();
            }
        }
 
       /* public static void main(String[] args) throws Exception {
            // input arguments
        	bookings = new ArrayList<>(800);
        
        	Booking booking = new Booking(0);
        	Booking booking2 = new Booking(1);
        	Booking booking3 = new Booking(2);
        	Booking booking4 = new Booking(3);
        	bookings.add(booking);
        	bookings.add(booking2);
        	bookings.add(booking3);
        	bookings.add(booking4);
            String queueName = "jms/mdw-queue" ;
 
            // create the producer object and send the message
            JMSProducer producer = new JMSProducer();
            producer.send(queueName, booking.getMessage());
            producer.send(queueName, booking2.getMessage());
            producer.send(queueName, booking3.getMessage());
            producer.send(queueName, booking4.getMessage());
           
            String queueName2 = "jms/mdw-queue2" ; 
            JMSConsumer consumer = new JMSConsumer();
            consumer.receive(queueName2);
        }*/
 
}