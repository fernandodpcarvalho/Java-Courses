package com.tests.alura.sockets;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

//Implementa o padrão FrontController
public class DistribuirTarefas implements Runnable {

	private Socket socket;

	public DistribuirTarefas(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println("Distribuindo tarefas para " + socket);
			Scanner entradaCliente = new Scanner(socket.getInputStream());
			PrintStream saidaCliente = new PrintStream(socket.getOutputStream());
			while (entradaCliente.hasNextLine()) {
				String comando = entradaCliente.nextLine();
				switch (comando) {
					case "c1": {
						saidaCliente.println("Confirmação comando c1");
						break;
					}
					case "c2": {
						saidaCliente.println("Confirmação comando c2");
						break;
					}
					case "exit": {
						saidaCliente.println("Desligando servidor");
						break;
					}
					default: {
						saidaCliente.println("Comando não encontrado.");
					}
				}
				System.out.println(comando);
			}
			saidaCliente.close();
			entradaCliente.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
