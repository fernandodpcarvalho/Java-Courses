package br.com.caelum.estruturais.decorator;

public abstract class Filtro {
	
	private Filtro outroFiltro;
	
	protected Filtro(){		
		this.outroFiltro = null;
	}
	
	protected Filtro(Filtro outroFiltro){
		this.outroFiltro = outroFiltro;
	}
	
	protected abstract boolean aplicaFiltro(Conta conta);
	
	protected boolean AplicaFiltroComposto(Conta conta){
		if(this.outroFiltro != null) return this.outroFiltro.aplicaFiltro(conta);
		else return false;
	}

}
