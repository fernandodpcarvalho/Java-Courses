import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		// List<String> palavras = Arrays.asList("alura online", "casa do
		// código", "caelum");

		// Ordenação em Java 7
		Collections.sort(palavras);
		System.out.println(palavras);

		// Ordenação com java7 com outro critério de ordenação:
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		Collections.sort(palavras, comparador);
		System.out.println(palavras);

		// Ordenação com Java8
		palavras.sort(comparador);
		System.out.println(palavras);

		// foreach com java 7
		for (String palavra : palavras) {
			System.out.println(palavra);
		}

		// foreach com java 8
		Consumer<String> consumidor = new ConsumidorDeString();
		palavras.forEach(consumidor);
		
		
		//Usando classe anônima
		Consumer<String> consumidor2 = new Consumer<String>() {
		    public void accept(String s) {
		        System.out.println(s);
		    }
		};
		palavras.forEach(consumidor2);
		
		//Outra forma de usar classe anônima:
		palavras.forEach(new Consumer<String>() {
		    public void accept(String s) {
		        System.out.println(s);
		    }
		});
		
		
		//Com lambda:
		palavras.forEach((String s) -> {
		    System.out.println(s);
		});
		
		//ou
		palavras.forEach(s -> System.out.println(s));
		
		//Sort com lambda
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		
		palavras.forEach(new Consumer<String>(){
		    public void accept(String palavra) {
		        System.out.println(palavra);
		    }
		});
		
		palavras.forEach(s1 -> System.out.println(s1));

		
		palavras.sort(new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        if(s1.length() < s2.length()) 
		            return -1;
		        if(s1.length() > s2.length()) 
		            return 1;
		        return 0;
		    }
		});
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
		//Comparing = método default estático - fabrica de comparator.
		//Recebe um lambda como parâmetro
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		//Expressão acima desmembrada.
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparador3 = Comparator.comparing(funcao);
		palavras.sort(comparador3);
		
	}

}
