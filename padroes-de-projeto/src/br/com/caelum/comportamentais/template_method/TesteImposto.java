package br.com.caelum.comportamentais.template_method;

public class TesteImposto {
	
	public static void main(String[] args) {
		Imposto icpp = new ICPP();
		Imposto ickv = new IKCV();
		
		Orcamento orcamento = new Orcamento();
	    orcamento.adicionaItem(new Item("CANETA", 90.0));
	    orcamento.adicionaItem(new Item("LAPIS", 80.0));
	    orcamento.adicionaItem(new Item("BORRACHA", 70.0));
	    orcamento.adicionaItem(new Item("COMPASSO", 90.0));
	    orcamento.adicionaItem(new Item("LAPISEIRA", 80.0));
	    orcamento.adicionaItem(new Item("PAPEL", 70.0));
	    
	    System.out.println(icpp.calcula(orcamento));
	    System.out.println(ickv.calcula(orcamento));

	    orcamento.adicionaItem(new Item("ESTOJO", 90.0));

	    System.out.println(icpp.calcula(orcamento));
	    System.out.println(ickv.calcula(orcamento));
	    
	    orcamento.adicionaItem(new Item("LANCHEIRA", 150.0));

	    System.out.println(icpp.calcula(orcamento));
	    System.out.println(ickv.calcula(orcamento));
	}
}
