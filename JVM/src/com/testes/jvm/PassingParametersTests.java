package com.testes.jvm;

public class PassingParametersTests {

	public static void main(String[] args) {
		
		//Teste de variáveis final
		Cidadao cidadao = new Cidadao("Fernando");
		System.out.println(cidadao);
		
//		cidadao = new Cidadao("Vitor");
		cidadao.nome = "Vitor";
		System.out.println(cidadao);
		System.gc();
		
		//object will be modified inside the called method  
		alterar(cidadao);
		System.out.println(cidadao);
		
		// A final variable can only be assigned once
		final Cidadao c = new Cidadao("Final Test");
		c.nome = "We can modify the object variables";
//		c = new Cidadao("But we cannot modify the c variable assign");
	}
	
	private static void alterar(Cidadao c) {
		System.out.println("Alterando o cidadão: "+c+" para: Thais");
		c.nome = "Thais";
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
		System.out.println("GC destroying object: "+this+"");
	}
	@Override
	public String toString() {
		return this.nome;
	}
}
