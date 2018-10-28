package br.com.caelum.estruturais.decorator;

public class FiltroSaldoMaiorQueQuinhentos extends Filtro {	

	public FiltroSaldoMaiorQueQuinhentos() {
		super();
	}

	public FiltroSaldoMaiorQueQuinhentos(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	protected boolean aplicaFiltro(Conta conta) {
		if(conta.getSaldo() > 500) {
			System.out.println("Saldo maior que 500");
			return true;
		}
		else return AplicaFiltroComposto(conta);
	}

}
