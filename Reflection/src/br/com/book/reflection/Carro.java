package br.com.book.reflection;

public class Carro {
	String nome;
	String cor;
	double preco;

	public Carro(String nome, String cor, double preco) {
		this.nome = nome;
		this.cor = cor;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NomePropriedade("Cor do carro")
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Ignorar
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
