package br.com.caelum.jms.filas;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ConsumidorFila {
	
	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext context = new InitialContext();
		ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination fila = (Destination) context.lookup("financeiro");
		MessageConsumer consumer = session.createConsumer(fila);

		consumer.setMessageListener(new MessageListener() {
		    public void onMessage(Message message) {
//				System.out.println(message);
		        TextMessage textMessage  = (TextMessage) message;
		        try {
					System.out.println(textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
		    }
		});
		
		new Scanner(System.in).nextLine();
		
//		Message message = consumer.receive();
//		System.out.println("Recebendo msg: "+ message);

		session.close();
		connection.close();
		context.close();
		
	}
		
}