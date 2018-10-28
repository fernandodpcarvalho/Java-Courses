package br.com.caelum.estruturais.decorator;

//Representa um orcamento. Cada valor de orcamento está sujeito a um determinado imposto
public class Orcamento {

  private double valor;

  public Orcamento(double valor) {
      this.valor = valor;
  }

  public double getValor() {
      return valor;
  }

}