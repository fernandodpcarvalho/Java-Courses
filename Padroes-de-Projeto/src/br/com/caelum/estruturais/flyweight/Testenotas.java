package br.com.caelum.estruturais.flyweight;

import java.util.Arrays;
import java.util.List;

public class Testenotas {
	public static void main(String[] args) {
		
		NotasMusicais notas = new NotasMusicais();
		
		List<Nota> musica = Arrays.asList(
	            notas.pega("do"),    
	            notas.pega("re"),    
	            notas.pega("mi"),    
	            notas.pega("fa"),    
	            notas.pega("fa"),    
	            notas.pega("fa")    
		        );        
		
		for (Nota nota : musica) {
			System.out.println(nota.simbolo());			
		}
		
		Piano piano = new Piano();
		piano.toca(musica);
	}
}
