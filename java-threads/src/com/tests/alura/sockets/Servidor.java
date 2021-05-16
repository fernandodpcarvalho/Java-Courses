package com.tests.alura.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Servidor {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("---- Iniciando Servidor ----");
		ServerSocket servidor = new ServerSocket(12345); //Servidor tem uma porta única especificada.
		
		//Criar um pool de threads para reaproveitá-las, economizando o custo de criar sempre uma nova.
//		ExecutorService threadPool = Executors.newFixedThreadPool(2);
//		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		ExecutorService threadPool = Executors.newCachedThreadPool();
		
		while(true) {
			Socket socket = servidor.accept();
			System.out.println("Aceitando novo cliente na porta: "+socket.getPort());
			
			DistribuirTarefas distribuirTarefas = new DistribuirTarefas(socket);
//			Thread threadCliente = new Thread(distribuirTarefas);
//			threadCliente.start();
			threadPool.execute(distribuirTarefas);
		}
	}
}
