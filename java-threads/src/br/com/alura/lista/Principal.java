package br.com.alura.lista;

public class Principal {

	public static void main(String[] args) throws InterruptedException {

		Lista lista = new Lista();
//		List<String> lista = new ArrayList<>();
//		List<String> lista = new Vector<>();
//		List<String> lista = Collections.synchronizedList(new ArrayList<>());

		for (int i = 0; i < 10; i++) {
			new Thread(new TarefaAdicionarElemento(lista, i)).start();
		}

		new Thread(new TarefaImprimir(lista)).start();
		
//		Thread.sleep(2000);
//		for (int i = 0; i < lista.tamanho(); i++) {
//			System.out.println(i + " - " + lista.pegaElemento(i));
//		}
	}
}
