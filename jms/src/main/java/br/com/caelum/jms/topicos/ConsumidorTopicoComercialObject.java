package br.com.caelum.jms.topicos;

import java.util.Scanner;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.ActiveMQConnectionFactory;

import br.com.caelum.jms.model.Pedido;

public class ConsumidorTopicoComercialObject {
	
	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext context = new InitialContext();
		ActiveMQConnectionFactory factory = (ActiveMQConnectionFactory) context.lookup("ConnectionFactory");
		factory.setTrustAllPackages(true);
		Connection connection = factory.createConnection();
		connection.setClientID("comercial");
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Topic topico = (Topic) context.lookup("loja");
		MessageConsumer consumer = session.createDurableSubscriber(topico, "assinatura-comercial");

        consumer.setMessageListener(new MessageListener() {

            public void onMessage(Message message) {
        		ObjectMessage objectMessage = (ObjectMessage)message;
                try {
                	Pedido pedido = (Pedido) objectMessage.getObject();
                    System.out.println(pedido);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                
//            	TextMessage textMessage = (TextMessage) message;
//            	try {
//            		System.out.println(textMessage.getText());
//            	} catch (JMSException e) {
//            		e.printStackTrace();
//            	}
            }
        });


        new Scanner(System.in).nextLine();

        session.close();
        connection.close();
        context.close();
		
	}
		
}