package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

class TesteDoAvaliador {

	public static void main(String[] args) {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

//		leilao.propoe(new Lance(joao, 300.0));
//		leilao.propoe(new Lance(jose, 400.0));
//		leilao.propoe(new Lance(maria, 250.0))
		
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		// comparando a saida com o esperado
        double maiorEsperado = 400;
        double menorEsperado = 250;

        System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
        System.out.println(menorEsperado == leiloeiro.getMenorLance());
	}
}
