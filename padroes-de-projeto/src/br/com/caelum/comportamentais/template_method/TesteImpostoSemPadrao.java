package br.com.caelum.comportamentais.template_method;

public class TesteImpostoSemPadrao {
	
	public static void main(String[] args) {

		ICPPSemPadrao icpp = new ICPPSemPadrao();
		IKCVSemPadrao ickv = new IKCVSemPadrao();
		
		Orcamento orcamento = new Orcamento();
	    orcamento.adicionaItem(new Item("CANETA", 40.0));
	    orcamento.adicionaItem(new Item("LAPIS", 30.0));
	    orcamento.adicionaItem(new Item("BORRACHA", 30.0));

	    System.out.println(icpp.calcula(orcamento));
	    System.out.println(ickv.calcula(orcamento));

	    orcamento.adicionaItem(new Item("REGUA", 50.0));
	    orcamento.adicionaItem(new Item("ESTOJO", 150.0));

	    System.out.println(icpp.calcula(orcamento));
	    System.out.println(ickv.calcula(orcamento));
	}
	
}

class ICPPSemPadrao implements Imposto {
    public double calcula(Orcamento orcamento) {
      if(orcamento.getValor() > 500) {
        return orcamento.getValor() * 0.07;
      } else {
        return orcamento.getValor() * 0.05;
      }
    }
}

class IKCVSemPadrao implements Imposto {
    public double calcula(Orcamento orcamento) {
      if(orcamento.getValor() > 500 && temItemMaiorQue100ReaisNo(orcamento)) {
        return orcamento.getValor() * 0.10;
      } else {
        return orcamento.getValor() * 0.06;
      }
    }

    private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
      for(Item item : orcamento.getItens()) {
        if(item.getValor() > 100) return true;
      }

      return false;
    }
}

