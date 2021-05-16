package br.com.alura.test;

import java.util.Random;

public class TestThread {
	
	public static void main(String[] args) {
		//Usando classe que extende Thread - Não recomendado.
		HelloWorldThread helloWorldThread = new HelloWorldThread();
		helloWorldThread.start();
		
		//Usando Runnable 
		Runnable helloWorldRunnable = new HelloWorld();
		Thread helloWorld = new Thread(helloWorldRunnable, "HelloWorldThread");
		helloWorld.start();	
		
		for(int i=0;i<10;i++) {
			Runnable randonPrintRunnable = new RandomPrint(String.valueOf(i));
			Thread randomPrint = new Thread(randonPrintRunnable, "RandomPrintThread"+i);
			randomPrint.start();
		}
		
		//Usando classe anônima (Para tarefas pequenas)
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Finished!!!");
			}
		}).start();
	}
}

class HelloWorldThread extends Thread {
	@Override
	public void run() {
		System.out.println("Hello World Thread!!!");
	}
}

class HelloWorld implements Runnable {
	@Override
	public void run() {
		System.out.println("Hello World!!!");
	}
}

class RandomPrint implements Runnable {
	private String text;
	public RandomPrint(String text) {
		this.text = text;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(new Random().nextInt(3000));
			System.out.println(text);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
}

