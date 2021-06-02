package com.br.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/*
 * Default method
 * Lambdas
 * Interfaces funcionais
 * Method References
 */

public class OrdenaStrings {
	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("Fernando");
		palavras.add("Thais");
		palavras.add("Isabela");
		
		//Ordenação da forma antiga:
		//Ordem alfabética
		Collections.sort(palavras);
		System.out.println(palavras);
		//Criando um comparador para ordenar por tamanho da string
		Comparator<String> comparador = new ComparadorPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);
		
		//Novo default method sort incluído na interface List
		palavras.sort(comparador);
		
		//Agora usando lambda para criar o Comparator:
		//Lambda precisa de uma interface funcional (que possui somente um método abstrato)
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		//foreach antigo
		for (String s : palavras) {
			System.out.println(s);
		}
		
		//Criando um consumer
		Consumer<String> consumidor = new ImprimeNaLinha();
		//Novo default method forEach incluído na interface Iterable. 
		palavras.forEach(consumidor);
		
		//Criando o mesmo consumer usando classe anônima
		palavras.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
		
		//Usando função lambda
		palavras.forEach(s -> System.out.println(s));
		
		//Este código abaixo:
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparador2 = Comparator.comparing(funcao);
		palavras.sort(comparador2);
		
		//É o mesmo que este abaixo:
		palavras.sort(Comparator.comparing(s -> s.length()));
		//comparing = factory de comparators. Recebe uma instância de uma interface funcional.
		//No caso da interface function, que possui apenas um método apply()
		//java.util.functions
		
		//Usando Method Reference: (OBS: Não é reflection)
		palavras.sort(Comparator.comparing(String::length));
		palavras.forEach(System.out::println);
	}
}

//Implementa a interface funcional Consumer
class ImprimeNaLinha implements Consumer<String> {
	@Override
	public void accept(String s) {
		System.out.println(s);
	}
}

class ComparadorPorTamanho implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length()) return -1;
		if(s1.length() > s2.length()) return 1;
		return 0;
	}
}