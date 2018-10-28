package br.com.caelum.comportamentais.visitor;

public interface Visitor {
    void visitaSoma(Soma soma);
    void visitaSubtracao(Subtracao subtracao);
    void visitaNumero(Numero numero);
    void visitaMultiplicacao(Multiplicacao multiplicacao);
    void visitaDivisao(Divisao divisao);
}