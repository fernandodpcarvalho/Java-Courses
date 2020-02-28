package br.com.caelum.estruturais.decorator;

public class FiltroSaldoMenorQueCem extends Filtro {	

	public FiltroSaldoMenorQueCem() {
		super();
	}

	public FiltroSaldoMenorQueCem(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	protected boolean aplicaFiltro(Conta conta) {
		if(conta.getSaldo() < 100) {
			System.out.println("Saldo é menor que 100");
			return true;
		}
		else return AplicaFiltroComposto(conta);
	}

}
