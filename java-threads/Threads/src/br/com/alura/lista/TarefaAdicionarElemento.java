package br.com.alura.lista;

public class TarefaAdicionarElemento implements Runnable {

	private Lista lista;
	private int numThread;

	public TarefaAdicionarElemento(Lista lista, int numThread) {
		this.lista = lista;
		this.numThread = numThread;
	}

	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			lista.adicionaElementos("Thread "+numThread+" - "+i);
		}

	}

}
