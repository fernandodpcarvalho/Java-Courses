package com.testes;

public class Operacao {
	
	public int divisao(int numerador, int denominador) throws DivisaoPorZeroException {
		if(denominador == 0) throw new DivisaoPorZeroException(numerador, denominador);
		else return numerador/denominador;
	}
}
