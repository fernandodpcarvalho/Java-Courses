package br.com.alura;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SubmissionPublisher;

import br.com.alura.model.NotaFiscal;
import br.com.alura.subscriber.NotaFiscalSubscriber;
import br.com.alura.wsclient.NotaFiscalWSClient;

/*
 * Flow API - Java9
 */

public class TesteEnvioNaoBloqueante {

	public static void main(String[] args) {
		System.out.println("Thread: " + Thread.currentThread().getName());
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		SubmissionPublisher<NotaFiscal> publisher = new SubmissionPublisher<>(newFixedThreadPool, 1);
//		
		NotaFiscal primeiraNotaFiscal = new NotaFiscal("Joao", 39.99, LocalDate.now());		
//		NotaFiscalWSClient nfwsc = new NotaFiscalWSClient();
//		publisher.consume(nfwsc::enviar);
//		publisher.consume(data -> {
//			System.out.println("Outra Thread: "+ Thread.currentThread().getName());
//		});
		
		NotaFiscalSubscriber subscriber = new NotaFiscalSubscriber();
		publisher.subscribe(subscriber);		
		publisher.submit(primeiraNotaFiscal);
		System.out.println("Voce ira receber a nota fiscal no seu e-mail");
		
		List<NotaFiscal> notasFiscais = List.of(new NotaFiscal("Joao", 39.99, LocalDate.now()),
				new NotaFiscal("Renata", 41.20, LocalDate.now()), new NotaFiscal("Paulo", 32.10, LocalDate.now()),
				new NotaFiscal("Feranda", 15.00, LocalDate.now()));
		
		notasFiscais.forEach(nf -> {
			publisher.submit(nf);
			System.out.println("Parabens pela compra!!");
		});
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();
		publisher.close();
	}
}
