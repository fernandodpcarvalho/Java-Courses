package br.com.caelum.estruturais.flyweight;

import java.util.List;

public class Piano {
	
	public void toca(List<Nota> musica){
		Player player = new Player();
		
		StringBuilder musicaEmNotas = new StringBuilder();
		for (Nota nota : musica) {
			musicaEmNotas.append(nota.simbolo() + " ");
		}
		System.out.println(musicaEmNotas.toString());
		player.play(musicaEmNotas.toString());		
	}
}

class Player {
	public void play(String musica) {
		System.out.println("musica");
	}
}
