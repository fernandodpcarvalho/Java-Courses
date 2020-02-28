package br.com.caelum.comportamentais.state;

public class TesteContaBancaria {
	public static void main(String[] args) {
		Conta c1 = new Conta("Fernando", "12345", 100.0, "10");
		c1.deposito(50.0);
		c1.saque(60.0);
		c1.saque(60.0);
		c1.saque(60.0);
		c1.deposito(100.0);
		c1.saque(200.0);
		c1.saque(10.0);
	}
}


class Conta {
	protected String Nome;
	protected String Numero;
	protected double Saldo;
	protected String Agencia;
	
	protected EstadoConta estadoConta;

	public Conta(String nome, String numero, double saldo, String agencia) {
		Nome = nome;
		Numero = numero;
		Saldo = saldo;
		Agencia = agencia;
		this.estadoConta = new Positivo();
		System.out.println("\nNova "+this);
	}
	
	void saque(double valor){
		this.estadoConta.saque(this, valor);
		System.out.println("\nSaque de "+valor+" realizado com sucesso!");
		System.out.println(this);
	}
	
	void deposito(double valor){
		this.estadoConta.deposito(this, valor);
		System.out.println("\nDeposito de "+valor+" realizado com sucesso!");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Conta [Nome=" + Nome + ", Numero=" + Numero + ", Saldo=" + Saldo + ", Agencia=" + Agencia
				+ ", estadoConta=" + estadoConta + "]";
	}
	
	
}

interface EstadoConta{
	void saque(Conta conta, double valor);
	void deposito(Conta conta, double valor );
}

class Positivo implements EstadoConta{

	@Override
	public void saque(Conta conta, double valor) {
		conta.Saldo -= valor;
		if(conta.Saldo < 0) conta.estadoConta = new Negativo();
	}

	@Override
	public void deposito(Conta conta, double valor) {
		conta.Saldo += (valor * 0.98);
	}

	@Override
	public String toString() {
		return "Positivo";
	}
	
	
}

class Negativo implements EstadoConta{

	@Override
	public void saque(Conta conta, double valor) {
		//conta.Saldo -= valor;
		 throw new RuntimeException("Sua conta está negativa. Não é possível sacar!");
	}

	@Override
	public void deposito(Conta conta, double valor) {
		conta.Saldo += (valor * 0.95);
		if(conta.Saldo >= 0) conta.estadoConta = new Positivo();
	}

	@Override
	public String toString() {
		return "Negativo";
	}
	
	
}

