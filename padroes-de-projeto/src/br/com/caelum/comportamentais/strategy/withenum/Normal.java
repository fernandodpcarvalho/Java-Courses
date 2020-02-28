package br.com.caelum.comportamentais.strategy.withenum;

import br.com.caelum.comportamentais.strategy.withenum.Frete;

public class Normal implements Frete {

	public double calcularPreco(int distancia) {
		return distancia * 1.25 + 10;
	}
	
}
