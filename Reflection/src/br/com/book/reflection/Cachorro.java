package br.com.book.reflection;

public class Cachorro implements Animal {
	
	String nome;
	
	public Cachorro(String nome) {
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
		return "auau";
	} 
}
