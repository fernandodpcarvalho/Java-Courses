package br.com.caelum.estruturais.decorator;

//Implementa o tipo imposto ICMS com valor específico de calculo
public class ICMS extends Imposto {
	
	public ICMS(){
		super();
	}

    public ICMS(Imposto outroImposto) {
        super(outroImposto);
    }
/*	
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.1;
    }
  */  
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.01 + calculoDoOutroImposto(orcamento);
    }

}
