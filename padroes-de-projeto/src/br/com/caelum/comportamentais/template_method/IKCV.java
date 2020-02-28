package br.com.caelum.comportamentais.template_method;

public class IKCV extends TemplateDeImpostoCondicional {

    public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
      return orcamento.getValor() > 500 && temItemMaiorQue100ReaisNo(orcamento);
    }
    public double maximaTaxacao(Orcamento orcamento) { 
      return orcamento.getValor() * 0.10;  
    }
    public double minimaTaxacao(Orcamento orcamento) {
      return orcamento.getValor() * 0.06;
    }

    // retorna verdadeiro caso algum item seja maior que 100 reais
    private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
    	for (Item item  : orcamento.getItens()) {
			if(item.getValor() > 100) return true;
		}
    	return false;
    }
  }
