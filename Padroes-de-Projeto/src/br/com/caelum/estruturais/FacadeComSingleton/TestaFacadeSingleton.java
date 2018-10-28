package br.com.caelum.estruturais.FacadeComSingleton;

public class TestaFacadeSingleton {
	
	public static void main(String[] args) {
		EmpresaFacade fachada = new EmpresaFacadeSingleton().getInstancia();
	}

}
