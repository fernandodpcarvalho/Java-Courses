package br.com.alura.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class PetDAO {
	
	HttpClient httpClient = null;

	public PetDAO() {
		this.httpClient = HttpClient.newBuilder().build();
	}

	public void listarSincrono() throws URISyntaxException, IOException, InterruptedException {
		System.out.println("...Iniciando requisição síncrona");
		HttpResponse<String> resp = httpClient.send(
				HttpRequest.newBuilder().uri(new URI("https://petstore.swagger.io/v2/pet/1")).GET().build(),
				BodyHandlers.ofString());
		System.out.println("Resposta requisição síncrona: \n" + resp.body());
	}

	public void listarAssincrono() throws URISyntaxException {
		System.out.println("...Iniciando requisição assíncrona");
		// CompletableFuture<HttpResponse<String>> resp = httpClient.sendAsync(
		httpClient.sendAsync(HttpRequest.newBuilder().uri(new URI("https://petstore.swagger.io/v2/pet/2")).GET().build(),
				BodyHandlers.ofString()).whenComplete((s, t) -> System.out.println("Resposta requisição assíncrona: \n" + s.body()));

	}
}
