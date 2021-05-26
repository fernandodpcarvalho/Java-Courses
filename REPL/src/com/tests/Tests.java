package com.tests;

public class Tests {

	public static void main(String[] args) {
//		Integer a = 5000;
//		Integer b = 5000;
//		System.out.println(a.equals(b));
//		System.out.println(a == b);	
//		
//		Integer c = 50;
//		Integer d = 50;
//		System.out.println(a.equals(b));
//		System.out.println(a == b);
		
		String name = "Fernando";
		System.out.println(name.hashCode());
		
		Pessoa fernando = new Pessoa("Fernando", 37, 322312);
		System.out.println(fernando.hashCode());
		
		
	}

}


class Pessoa {
	String name;
	int idade;
	int cpf;
	public Pessoa(String name, int idade, int cpf) {
		this.name = name;
		this.idade = idade;
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cpf;
		result = prime * result + idade;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf != other.cpf)
			return false;
		if (idade != other.idade)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	
	
}