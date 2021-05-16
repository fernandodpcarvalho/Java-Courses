package br.com.alura.banheiro;

public class Principal {
	public static void main(String[] args) {
		
		Banheiro banheiro = new Banheiro();

		Thread convidado1 = new Thread(new Tarefa1(banheiro), "Joao");		
		Thread convidado2 = new Thread(new Tarefa2(banheiro), "Pedro");
		Thread limpeza    = new Thread(new TarefaLimpeza(banheiro),"Limpeza");
//		Thread convidado3 = new Thread(new Tarefa1(banheiro), "Maria");		
//		Thread convidado4 = new Thread(new Tarefa2(banheiro), "Ana");
		
		//JVM exits when the only threads running are all daemon threads.
		//Daemon Thread são provedores de serviços para outras threads
		limpeza.setDaemon(true);  
		
		//Para dar maior prioridade a uma thread:
//		limpeza.setPriority(10);
//		limpeza.setPriority(Thread.MAX_PRIORITY);

		convidado1.start();
		convidado2.start();
		limpeza.start();
//		convidado3.start();
//		convidado4.start();
		
	}
}
