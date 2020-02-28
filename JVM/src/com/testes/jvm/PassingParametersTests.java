package com.testes.jvm;

public class PassingParametersTests {

	public static void main(String[] args) {
		
		//Teste de variáveis final
		final Cidadao cidadao = new Cidadao("Fernando");
		System.out.println(cidadao);
//		cidadao = new Cidadao("Vitor");
		cidadao.nome = "Vitor";
		
		System.out.println(cidadao);
		alterar(cidadao);
		System.out.println(cidadao);
		gc();
	}
	
	private static void alterar(Cidadao c) {
		System.out.println("Alterando o cidadão: "+c);
		c.nome = "Thais";
	}
	
	static void gc() {
		System.out.println("Garbage Collection Calling Start ");
		try {
			System.gc();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Garbage Collection Calling Finished ");
	}

}

class Cidadao {
	Cidadao p = null;
	String nome;
	
	public Cidadao(String nome) {
		this.nome = nome;
		System.out.println("Creating object: "+nome);
	}
	@Override
	protected void finalize() {
		System.out.println("Destroying object: "+this+"");
	}
	@Override
	public String toString() {
		return this.nome;
	}
}
