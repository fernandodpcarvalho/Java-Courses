package br.com.alura.multiplicacao;

public class Principal {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Teste thread");
		
		Thread.sleep(30000);
		
		System.out.println("Pós teste thread");
	}
}
