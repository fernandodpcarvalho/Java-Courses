package com.br.alura.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		cursos.forEach(c -> System.out.println(c.getNome()));

		// Stream não modifica a collection real. É preciso criar um objeto stream.
		// São thread safe, lazy
		// Interface "fluente"
		System.out.println("\n--- Stream ---");
		Stream<Curso> streamDeCurso = cursos.stream();
		streamDeCurso.filter(c -> c.getAlunos() > 100) // predicado
					 .forEach(c -> System.out.println(c.getNome()));

		cursos.stream().filter(c -> c.getAlunos() < 100) // Aqui tem que usa lambda
					   .map(Curso::getAlunos) // Aqui pode usar method references
				       .forEach(System.out::println);
		
		IntStream stream = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.mapToInt(Curso::getAlunos);
		stream.forEach(System.out::println);
		
		//Stream e Collection não são a mesma coisa.
		
		System.out.println("/n---Optional---");
		Optional<Curso> optionalCurso = cursos.stream()
				.filter(c -> c.getAlunos() >= 100)
				.findAny();
		
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
		
		System.out.println("De stream para collection");
		List<Curso> cursosList = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.collect(Collectors.toList());
		
		cursosList.forEach(c -> System.out.println(c.getNome()));
	}
}
