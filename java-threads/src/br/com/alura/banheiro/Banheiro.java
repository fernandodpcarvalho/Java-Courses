package br.com.alura.banheiro;

public class Banheiro {
	
	public boolean ehSujo = true;

	//Outra forma de fazer lock:
	//private Lock lock = new ReentrantLock();
	//lock.lock(); lock.unlock();
	
	public void numero1() {
		//Obtém a thread atual
		String nome = Thread.currentThread().getName();
		System.out.println(nome+" batendo na porta");
		//Bloqueia a execução para uma thread por vez. Atômico.
		synchronized(this) {
			System.out.println(nome+" entrando no banheiro");
			while(ehSujo){
				esperaLaFora(nome);
			}
			System.out.println(nome+" fazendo numero1");
			dormir(5000);
			this.ehSujo = true;
			System.out.println(nome+" dando descarga");
			System.out.println(nome+" lavando as mãos");
			System.out.println(nome+" saindo do banheiro");
		}
	}
	
	public void numero2() {
		String nome = Thread.currentThread().getName();
		System.out.println(nome+" batendo na porta");
		synchronized(this) {
			System.out.println(nome+" entrando no banheiro");
			while(ehSujo) {
				esperaLaFora(nome);
			}
			System.out.println(nome+" fazendo numero2");
			dormir(10000);
			this.ehSujo = true;
			System.out.println(nome+" dando descarga");
			System.out.println(nome+" lavando as mãos");
			System.out.println(nome+" saindo do banheiro");
		}
	}
	
	public void limpa() {		
		String nome = Thread.currentThread().getName();
		System.out.println(nome+" batendo na porta");	
		synchronized(this) {
			System.out.println(nome+" entrando no banheiro");
			if(!ehSujo) {
				System.out.println(nome + " , não está sujo, vou sair");
				return;
			}
			System.out.println(nome+" limpando banheiro");	
			this.ehSujo = false;
			dormir(13000);
			this.notifyAll(); //Avisa as threads em wait que podem processar 
			System.out.println(nome+" saindo do banheiro");
		}
	}

	private void dormir(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void esperaLaFora(String nome) {
		System.out.println(nome+" banheiro sujo");
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
