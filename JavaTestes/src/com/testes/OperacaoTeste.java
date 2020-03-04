package com.testes;

public class OperacaoTeste {

	public static void main(String[] args) {
		
		System.out.println("Program argument: "+args[0]);
		
		int numerador = 10;
		int denominador = 5;
		try {
			System.out.println(new Operacao().divisao(numerador, denominador));
		} catch (DivisaoPorZeroException e) {
			e.printStackTrace();
		}
		
		numerador = 20;
		denominador = 0;
		try {
			System.out.println(new Operacao().divisao(numerador, denominador));
		} catch (DivisaoPorZeroException e) {
			e.printStackTrace();
		}
		
		
		numerador = 20;
		denominador = 4;
		try {
			System.out.println(new Operacao().divisao(numerador, denominador));
		} catch (DivisaoPorZeroException e) {
			e.printStackTrace();
		}
	}
}
