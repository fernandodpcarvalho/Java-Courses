package br.com.alura.lista;

public class TarefaImprimir implements Runnable {

	private Lista lista;
//	private List<String> lista;

	public TarefaImprimir(Lista lista) {
//	public TarefaImprimir(List<String> lista) {
		this.lista = lista;
	}

	@Override
	public void run() {
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
		synchronized (lista) {
			if (!lista.estaCheia()) {
				try {
					System.out.println("Impressora: Aguardando notificação");
					lista.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for (int i = 0; i < lista.tamanho(); i++) {
				System.out.println(i + " - " + lista.pegaElemento(i));
			}
		}
	}
}
