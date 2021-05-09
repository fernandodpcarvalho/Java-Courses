package br.com.book.reflection;

public class Gato implements Animal {
	
	String nome;
	public Gato(){}	
	public Gato(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String fala() {
		return "mial";
	} 
}
