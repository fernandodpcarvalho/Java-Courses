package br.com.caelum.comportamentais.strategy;

//Define que toda classe de tipo imposto deve implementar um método calculo específico
public interface Imposto {
    double calcula(Orcamento orcamento);
}
