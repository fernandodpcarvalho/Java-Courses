package br.com.caelum.estruturais.decorator;

public class TesteImpostoComposto {
	
	public static void main(String[] args) {

        Orcamento orcamento = new Orcamento(500.0);
		
		Imposto ISS  = new ISS();
		Imposto ICMS = new ICMS();

		System.out.println("ISS: "  + ISS.calcula(orcamento));
		System.out.println("ICMS: " + ICMS.calcula(orcamento));
		
		Imposto IssComIcms = new ISS(new ICMS());
		Imposto IcmsComIss = new ICMS(new ISS());

		System.out.println("IssComIcms: "+IssComIcms.calcula(orcamento));
		System.out.println("IcmsComIss: "+IcmsComIss.calcula(orcamento));		

		Imposto IssComIss = new ISS(new ISS());
		System.out.println("IssComIss: "+IssComIss.calcula(orcamento));
		
	}

}
