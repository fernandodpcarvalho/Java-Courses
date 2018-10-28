package br.com.caelum.comportamentais.strategy;

//Implementa o tipo imposto ISS com valor específico de calculo
public class ISS implements Imposto {

    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.06;
    }

}
