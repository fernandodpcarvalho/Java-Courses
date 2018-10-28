package br.com.caelum.comportamentais.visitor;

//Representa uma expressão, que pode ser uma operação ou apenas um número 
public interface Expressao {
    int avalia();
    void aceita(Visitor visitor);
}
