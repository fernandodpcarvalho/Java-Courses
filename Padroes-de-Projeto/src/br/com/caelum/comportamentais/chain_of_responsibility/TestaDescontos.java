package br.com.caelum.comportamentais.chain_of_responsibility;

public class TestaDescontos {
    public static void main(String[] args) {
      CalculadorDeDescontos calculador = new CalculadorDeDescontos();

      	  Orcamento orcamento = new Orcamento();
      	  
          orcamento.adicionaItem(new Item("CANETA", 250.0));
          
          System.out.println(calculador.calcula(orcamento));
          
          orcamento.adicionaItem(new Item("LAPIS", 250.0));

          System.out.println(calculador.calcula(orcamento));

          orcamento.adicionaItem(new Item("BORRACHA", 100.0));

          System.out.println(calculador.calcula(orcamento));

          orcamento.adicionaItem(new Item("REGUA", 150.0));
          orcamento.adicionaItem(new Item("COMPASSO", 200.0));
          orcamento.adicionaItem(new Item("ESTOJO", 300.0));
          
          System.out.println(calculador.calcula(orcamento));
          
    }
  }
