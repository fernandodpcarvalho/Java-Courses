package br.com.caelum.estruturais.decorator;

import java.util.Calendar;

public class Conta {
	private String Nome;
	private String Numero;
	private Integer Saldo;
	private String Agencia;
	private Calendar DataAbertura;

	public Conta() {
	}
	
	public Conta(String nome, String numero, Integer saldo, String agencia, Calendar dataAbertura) {
		Nome = nome;
		Numero = numero;
		Saldo = saldo;
		Agencia = agencia;
		DataAbertura = dataAbertura;
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

	public Integer getSaldo() {
		return Saldo;
	}

	public void setSaldo(Integer saldo) {
		Saldo = saldo;
	}

	public String getAgencia() {
		return Agencia;
	}

	public void setAgencia(String agencia) {
		Agencia = agencia;
	}

	public Calendar getDataAbertura() {
		return DataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		DataAbertura = dataAbertura;
	}
}