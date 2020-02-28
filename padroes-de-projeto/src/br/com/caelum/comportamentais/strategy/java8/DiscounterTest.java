package br.com.caelum.comportamentais.strategy.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DiscounterTest {

	public static void main(String[] args) {
		
		System.out.println(Discounter.christmasDiscounter().applyDiscount(new BigDecimal(1000)));
		System.out.println(Discounter.newYearDiscounter().applyDiscount(new BigDecimal(1000)));		
		System.out.println(Discounter.easterDiscounter().applyDiscount(new BigDecimal(1000)));
		
		
		
		List<Discounter2> discounters = new ArrayList<>();
		Discounter2 combinedDiscounter = discounters
				   .stream()
				   .reduce(v -> v, Discounter2::combine);
				 
		System.out.println(combinedDiscounter.apply(new BigDecimal(1000)));
	}
}
