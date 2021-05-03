package com.testes.jvm.memory.escaping_references_02;

import java.util.HashMap;
import java.util.Map;

public class Price {

	private Map<String,Double> rates;
	private Double value;
	
	public Price(Double value) {
		this.value = value;
		rates = new HashMap<String,Double>();
		rates.put("USD", 1d);
		rates.put("GBP", 0.6);
		rates.put("EUR", 0.8);
	}
		
	public Double convert(String toCurrency) {
		
		if (toCurrency.equals("USD")) {
			return value;
		}
		else {
			Double conversion = rates.get("USD") / rates.get(toCurrency);
//			value = conversion * value;
//			return value;
			return conversion * value; //Here the intern variable value is not modified.
		}
	}
	
	public String toString() {
		return this.value.toString();
	}

	//Error
//	public Map<String,Double> getRates() {
//		return rates;
//	}
	
	//Corrected
	public Double getRates(String currency) {
		return rates.get(currency);
	}
	
}
