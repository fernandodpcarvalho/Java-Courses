package br.com.caelum.estruturais.decorator;

import java.util.Calendar;

public class FiltroContaComDataDeAberturaMesCorrente extends Filtro {	

	public FiltroContaComDataDeAberturaMesCorrente() {
		super();
	}

	public FiltroContaComDataDeAberturaMesCorrente(Filtro outroFiltro) {
		super(outroFiltro);
	}

	@Override
	protected boolean aplicaFiltro(Conta conta) {
		if(conta.getDataAbertura().get(Calendar.MONTH) == Calendar.getInstance().get(Calendar.MONTH) &&
		   conta.getDataAbertura().get(Calendar.YEAR)  == Calendar.getInstance().get(Calendar.YEAR)) {
			System.out.println("Mês de abertura de conta é igual ao mês corrente");
			return true;
		}
		else return AplicaFiltroComposto(conta);
	}

}
