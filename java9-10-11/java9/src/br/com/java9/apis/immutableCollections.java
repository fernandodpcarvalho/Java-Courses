package br.com.java9.apis;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableMap;

public class immutableCollections {
	
	public static void main(String[] args) {
		
		//Mutable map
		Map<Integer, String> weekDays = new HashMap<>();
		weekDays.put(1, "Domingo");
		weekDays.put(2, "Segunda");
		weekDays.put(3, "Terça");
		weekDays.put(4, "Quarta");
		weekDays.put(5, "Quinta");
		weekDays.put(6, "Sexta");
		weekDays.put(7, "Sábado");
		System.out.println(weekDays.keySet());
		System.out.println(weekDays.values());
		
		//Immutable Map
		weekDays = Collections.unmodifiableMap(weekDays);
		//weekDays.put(8, "teste"); //error
				
		//Java 9: Immutable Collections 
		
		Map<Integer, String> ImmutableWeekDays = ImmutableMap.of(
				1, "Domingo", 
				2, "Segunda", 
				3, "Terça", 
				4, "Quarta", 
				5, "Quinta");
		
		Map<Integer, String> weekDays2 = Map.of(
				1, "Domingo",
				2, "Segunda",
				3, "Terça",
				4, "Quarta",
				5, "Quinta",
				6, "Sexta",
				7, "Sábado"
				);
		//Outras Collections imutáveis
		List<String> names = List.of("Rodrigo", "Vivian", "Alexandre");
		Set<String> colors = Set.of("azul", "vermelho", "amarelo");
	}
	


	
	
	
	
	
}
