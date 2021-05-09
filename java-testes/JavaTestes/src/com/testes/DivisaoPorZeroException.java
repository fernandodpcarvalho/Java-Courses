package com.testes;

public class DivisaoPorZeroException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int numerador;
	int denominador;

	public DivisaoPorZeroException(int numerador, int denominador) {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
	}

	@Override
	public String toString() {
		return "Não pode dividir por zero porra! - Numerador = " + this.numerador + " || Denominador = "
				+ this.denominador;
	}

}
