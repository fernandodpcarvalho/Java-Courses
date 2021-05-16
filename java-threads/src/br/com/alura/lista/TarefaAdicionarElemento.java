package br.com.alura.lista;

public class TarefaAdicionarElemento implements Runnable {

	private Lista lista;
//	private List<String> lista;
	private int numThread;

	public TarefaAdicionarElemento(Lista lista, int numThread) {
//	public TarefaAdicionarElemento(List<String> lista, int numThread) {
		this.lista = lista;
		this.numThread = numThread;
	}

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			lista.adicionaElementos("Thread "+numThread+" - "+i);
//			lista.add("Thread "+numThread+" - "+i);
		}
	}
}
