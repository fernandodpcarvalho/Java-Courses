package br.com.caelum.jms.filas;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

import br.com.caelum.jms.model.Pedido;

public class ConsumidorFilaDLQ {
	
	public static void main(String[] args) throws NamingException, JMSException {
	
		InitialContext context = new InitialContext();
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = connectionFactory.createConnection();
		connection.start();

//		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
		Destination fila = (Destination) context.lookup("DLQ");
		MessageConsumer consumer = session.createConsumer(fila);
	
		consumer.setMessageListener(new MessageListener() {
		    public void onMessage(Message message) {
		    	try {
					message.acknowledge();
					System.out.println(message);
				} catch (JMSException e) {
					e.printStackTrace();
				}
		    }
		});
		
		new Scanner(System.in).nextLine();
		
		session.close();
		connection.close();
		context.close();
		
	}
}