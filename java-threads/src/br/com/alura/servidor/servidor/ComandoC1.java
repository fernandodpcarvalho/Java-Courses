package br.com.alura.servidor.servidor;

import java.io.PrintStream;

//Classe que implementa o padrão Command (Ex: actions)
public class ComandoC1 implements Runnable {
	
	private PrintStream saida; //representa a saida do cliente

	public ComandoC1(PrintStream saida) {
		this.saida = saida;
	}

	public void run() {
		//será impresso no console do servidor
		System.out.println("Executando comando c1"); 
		//Este try/catch trata apenas o sleep
		try {
			Thread.sleep(20000);//simulando algo demorado
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		} 

		//essa mensagem será enviada para o cliente
	    this.saida.println("Comando c1 executado com sucesso!");
	}
}
