package br.com.alura.servidor.teste;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Properties;

public class Teste implements UncaughtExceptionHandler {

	public static void main(String[] args) {
		Properties properties = new Properties();
		Thread thread = new Thread(new LeitorPropriedades(properties, "arquivo1.txt"));
		// Aqui a própria classe Teste pode implementar a interface
		thread.setUncaughtExceptionHandler(new Teste());
		thread.start();
	}

	@Override
	public void uncaughtException(Thread thread, Throwable exception) {
		System.out.println("Exceção " + exception + " capturada na Thread " + thread.getName());
	}
}