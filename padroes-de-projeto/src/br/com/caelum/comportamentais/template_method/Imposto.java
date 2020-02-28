package br.com.caelum.comportamentais.template_method;

//Define que toda classe de tipo imposto deve implementar um método calculo específico
public interface Imposto {
    double calcula(Orcamento orcamento);
}
