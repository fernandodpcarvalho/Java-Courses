package com.tests.alura.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception {
		// Esta porta é do servidor. 
		// Mas o processo cliente vai ter uma porta atribuída pela JVM.
		Socket cliente = new Socket("localhost", 12345);
		System.out.println("Conexão estabelecida");

		Thread threadEnviaComando = new Thread(new Runnable() {
			@Override
			public void run() {
				try (PrintStream saida = new PrintStream(cliente.getOutputStream());
						Scanner teclado = new Scanner(System.in)) {
					while (teclado.hasNextLine()) {
						String linha = teclado.nextLine();
						if (linha.trim().equals("")) {
							break;
						}
						saida.println(linha);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread threadRecebeRespostaServidor = new Thread(new Runnable() {
			@Override
			public void run() {
				try (Scanner respostaServidor = new Scanner(cliente.getInputStream())) {
					System.out.println("Recebendo dados do servidor");
					while (respostaServidor.hasNextLine()) {
						String linha = respostaServidor.nextLine();
						System.out.println(linha);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		threadRecebeRespostaServidor.start();
		threadEnviaComando.start();
		
		//Faz com que a thread principal só volte a rodar quando as demais finalizarem.
		threadEnviaComando.join();
		
		cliente.close();
		
		//Criar threads usando lambda
//		new Thread( () -> { System.out.println("rodando");} ).start();
	}
}
