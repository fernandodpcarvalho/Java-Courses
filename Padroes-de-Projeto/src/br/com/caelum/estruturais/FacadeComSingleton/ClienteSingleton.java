package br.com.caelum.estruturais.FacadeComSingleton;

public class ClienteSingleton {
	protected Cliente cliente;
	
	public Cliente getClienteSingleton() {
		if(this.cliente == null) this.cliente = new Cliente();
		return this.cliente;
	}
	
}
