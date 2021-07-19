package br.com.java9.apis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {
	public static void main(String[] args) {
		Map<Integer, String> weekDays = new HashMap<>();
		weekDays.put(1, "Domingo");
		weekDays.put(2, "Segunda");
		weekDays.put(3, "Terça");
		weekDays.put(4, "Quarta");
		weekDays.put(5, "Quinta");
		weekDays.put(6, "Sexta");
		weekDays.put(7, "Sábado");
		
		System.out.println(weekDays); //{}
		System.out.println(weekDays.entrySet()); //[]
		
		//quebra se tiver algum valor nulo
//		List<String> dayNames = weekDays
//				.entrySet()
//				.stream()
//				.flatMap(e -> Stream.of(e.getValue()))
//				.map(s -> s.substring(0,3))
//				.collect(Collectors.toList());
//		System.out.println(dayNames);
		
		
		//ofNullable evita
//		List<String> dayNames = weekDays
//				.entrySet()
//				.stream()
//				.flatMap(e -> Stream.ofNullable(e.getValue()))
//				.map(s -> s.substring(0,3))
//				.collect(Collectors.toList());
//		System.out.println(dayNames);
		
		//Outros métodos de stream: .skip, .limit(), .dropWhile, .forEach, iterate
		
	}
}
