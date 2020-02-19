package br.com.caelum.jms.topicos;

import java.io.StringWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXB;

import br.com.caelum.jms.model.Pedido;
import br.com.caelum.jms.model.PedidoFactory;

public class ProdutorTopicoObject {
	
	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext context = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) context.lookup("ConnectionFactory");
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination topico = (Destination) context.lookup("loja");
        MessageProducer producer = session.createProducer(topico);
        
        Pedido pedido = new PedidoFactory().geraPedidoComValores();
        
        Message message = session.createObjectMessage(pedido);
        
        //Send a object
        producer.send(message);
        
        //Send a XML
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(pedido, stringWriter);
        String xml = stringWriter.toString();
        System.out.println(xml);
        
        message = session.createTextMessage(xml);
        producer.send(message);

        session.close();
        connection.close();
        context.close();
	}
		
}