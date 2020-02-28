package br.com.caelum.comportamentais.strategy.withenum;

import java.util.HashMap;
import java.util.Map;

import br.com.caelum.comportamentais.strategy.withenum.Frete;
import br.com.caelum.comportamentais.strategy.withenum.TipoFrete;

public class FreteTeste {

	public static void main(String[] args) {
		Map<String, Integer> fretes = new HashMap<>();
		fretes.put("Normal", 0);
		fretes.put("Sedex", 1);
		
		int distancia = 10;
		
		Frete frete = TipoFrete.values()[fretes.get("Normal")].obterFrete();		
		System.out.printf("O valor total é de R$%.2f\n", frete.calcularPreco(distancia));

		frete = TipoFrete.values()[fretes.get("Sedex")].obterFrete();
		System.out.printf("O valor total é de R$%.2f\n", frete.calcularPreco(distancia));
	}
	
}
