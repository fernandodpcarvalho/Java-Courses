package br.com.caelum.comportamentais.strategy.withoutif;

public class Venda {
	 
    private final Funcionario funcionario;
    private final double valor;

    public Venda(Funcionario funcionario, double valor) {
         this.funcionario = funcionario;
         this.valor = valor;
    }

    public double calculaComissao() {
    	return this.funcionario.getCargo().calculaComissao(valor);
    }

}
