package br.com.alura.banheiro;

public class Tarefa1 implements Runnable {

	private Banheiro banheiro;	

	public Tarefa1(Banheiro banheiro) {
		this.banheiro = banheiro;
	}

	@Override
	public void run() {
		this.banheiro.numero1();
	}

}
