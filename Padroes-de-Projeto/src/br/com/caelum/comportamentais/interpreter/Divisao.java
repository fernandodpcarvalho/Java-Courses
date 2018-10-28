package br.com.caelum.comportamentais.interpreter;

public class Divisao implements Expressao {

    private Expressao esquerda;
    private Expressao direita;

    public Divisao(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    @Override
    public int avalia() {
        int resultadoDaEsquerda = esquerda.avalia();
        int resultadoDaDireita = direita.avalia();
        if(resultadoDaDireita > 0) return resultadoDaEsquerda / resultadoDaDireita;
        else throw new RuntimeException("Não pode divisão por zero");
    }
}
