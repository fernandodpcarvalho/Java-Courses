package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
//			valor = BigDecimal.ZERO;
			throw new IllegalArgumentException("Funcionario com salário maior que R$10.000 não pode receber bonus.");
		}
		return valor;
	}

}