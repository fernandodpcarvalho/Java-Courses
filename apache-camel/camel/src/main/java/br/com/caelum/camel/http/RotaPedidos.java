package br.com.caelum.camel.http;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpMethods;
import org.apache.camel.impl.DefaultCamelContext;

public class RotaPedidos {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		context.addComponent("activemq", ActiveMQComponent.activeMQComponent("tcp://localhost:61616"));

		
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				errorHandler(
			    deadLetterChannel("file:erro").
			        maximumRedeliveries(3).
			            redeliveryDelay(3000).
			        onRedelivery(new Processor() {            
			            @Override
			            public void process(Exchange exchange) throws Exception {
			                        int counter = (int) exchange.getIn().getHeader(Exchange.REDELIVERY_COUNTER);
			                        int max = (int) exchange.getIn().getHeader(Exchange.REDELIVERY_MAX_COUNTER);
			                        System.out.println("Redelivery - " + counter + "/" + max );
			                    }
			        })
				);
				
//				from("file:pedidos?delay=5s&noop=true").
				from("activemq:queue:pedidos").
				    log("${file:name}").
					routeId("rota-pedidos").
				    delay(1000).
				    to("validator:pedido.xsd").
					multicast().
						to("direct:soap").
			            log("Chamando soap com ${body}").
						to("direct:http");
				
//				from("direct:soap").
//				    routeId("rota-soap").
//				to("xslt:pedido-para-soap.xslt").
//				    log("Resultado do Template: ${body}").
//				to("mock:soap");
			
				from("direct:soap").
				    routeId("rota-soap").
				to("xslt:pedido-para-soap.xslt").
				    log("Resultado do template: ${body}").
				    setHeader(Exchange.CONTENT_TYPE, constant("text/xml")).
				to("http4://localhost:8080/webservices/financeiro");
				
				from("direct:http").
					routeId("rota-http").
					setProperty("pedidoId", xpath("/pedido/id/text()")).
					setProperty("clientId", xpath("/pedido/pagamento/email-titular/text()")).
					split().
						xpath("/pedido/itens/item").
					filter().
						xpath("/item/formato[text()='EBOOK']").
					setProperty("ebookId", xpath("/item/livro/codigo/text()")).
					log("${id}").
					marshal().xmljson().
					log("${body}").
					setHeader(Exchange.HTTP_METHOD, HttpMethods.GET).
					setHeader(Exchange.HTTP_QUERY,constant("ebookId=ARQ&pedidoId=2451256&clienteId=edgar.b@abc.com")).
					setHeader(Exchange.HTTP_QUERY,simple("ebookId=${property.ebookId}&pedidoId=${property.pedidoId}&clienteId=${property.clientId}")).
				to("http4://localhost:8080/webservices/ebook/item");
			}
		});
		context.start();
		Thread.sleep(20000);
		context.stop();
	}	
}
