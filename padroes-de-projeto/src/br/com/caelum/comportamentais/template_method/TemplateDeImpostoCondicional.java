package br.com.caelum.comportamentais.template_method;

public abstract class TemplateDeImpostoCondicional implements Imposto {
    public double calcula(Orcamento orcamento) {

        if(deveUsarMaximaTaxacao(orcamento)) {
          return maximaTaxacao(orcamento);
        } else {
          return minimaTaxacao(orcamento);
        }

      } 

    protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);
    protected abstract double maximaTaxacao(Orcamento orcamento);
    protected abstract double minimaTaxacao(Orcamento orcamento);      
  }
