package br.com.caelum.comportamentais.template_method;

public class Conta {
	private String Nome;
	private String Numero;
	private String Saldo;
	private String Agencia;

	public Conta() {
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public String getSaldo() {
		return Saldo;
	}

	public void setSaldo(String saldo) {
		Saldo = saldo;
	}

	public String getAgencia() {
		return Agencia;
	}

	public void setAgencia(String agencia) {
		Agencia = agencia;
	}
}