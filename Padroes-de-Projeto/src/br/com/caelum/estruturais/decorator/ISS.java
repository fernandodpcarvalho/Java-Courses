package br.com.caelum.estruturais.decorator;

public class ISS extends Imposto {
	
	public ISS(){
		super();
	}
	
    public ISS(Imposto outroImposto) {
        super(outroImposto);
    }
/*
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.06;
    }
   */ 
    
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.06 + calculoDoOutroImposto(orcamento);
    }

/*    
    protected double calculoDoOutroImposto(Orcamento orcamento) {
      return outroImposto.calcula(orcamento);
    }
*/
}
