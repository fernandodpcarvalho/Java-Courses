package br.com.caelum.comportamentais.chain_of_responsibility;

//Implementa o tipo desconto por mais de 5 itens e qual o próximo da sequência.
public class DescontoPorVendaCasada implements Desconto {
    private Desconto proximo;

    public void setProximo(Desconto proximo) {
      this.proximo = proximo;
    }

    public double desconta(Orcamento orcamento) {
      if(orcamento.existe("LAPIS", orcamento) && orcamento.existe("CANETA", orcamento)) {
        return orcamento.getValor() * 0.05;
      }
      else {
        return proximo.desconta(orcamento);
      }
    }
  }
