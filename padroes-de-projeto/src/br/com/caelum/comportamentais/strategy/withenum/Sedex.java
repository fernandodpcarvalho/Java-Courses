package br.com.caelum.comportamentais.strategy.withenum;

import br.com.caelum.comportamentais.strategy.withenum.Frete;

public class Sedex implements Frete {

	public double calcularPreco(int distancia) {
		return distancia * 1.45 + 12;
	}
	
}
