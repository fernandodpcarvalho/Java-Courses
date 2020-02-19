package br.com.alura.loja;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.modelo.Projeto;

public class ProjetoTest {
	
	private HttpServer server;
	
	@Before
	public void startServidor(){
		server = Servidor.start();
	}

	@After
	public void stopServidor(){
		server.stop();
	}
/*
	@Test
	public void testaQueAConexaoComOServidorFunciona() {
		Client client = ClientBuilder.newClient();
		//WebTarget target = client.target("http://www.mocky.io");
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/projetos/1").request().get(String.class);
				
		System.out.println(conteudo);
		
		//Projeto projeto = (Projeto) new XStream().fromXML(conteudo); 
		Projeto projeto = (Projeto) new XStream().fromXML(conteudo); 
		
		Assert.assertEquals(2014 , projeto.getAnoDeInicio());
	
	}
	*/
	@Test
	public void testaPost() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Projeto projeto = new Projeto(3, "AmandaAmor", 2017);
        String xml = projeto.toXML();
        
        Entity<String> entity = Entity.entity(xml, MediaType.APPLICATION_XML);

        Response response = target.path("/projetos").request().post(entity);
        Assert.assertEquals("<status>sucesso</status>", response.readEntity(String.class));
		
	}
	
}
