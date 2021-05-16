package br.com.alura.servidor.servidor;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class JuntaResultadosFutureWSeBanco implements Callable<Void> {

	private Future<String> futureWS;
	private Future<String> futureBanco;
	private PrintStream saidaCliente;

	public JuntaResultadosFutureWSeBanco(Future<String> futureWS, Future<String> futureBanco,
			PrintStream saidaCliente) {
				this.futureWS = futureWS;
				this.futureBanco = futureBanco;
				this.saidaCliente = saidaCliente;
	}

	@Override
	public Void call() throws Exception{
		
		System.out.println("Aguardando resultados do futureWS e futureBanco");

		try {
			String numeromagico = this.futureWS.get(20, TimeUnit.SECONDS);
			String numeromagico2 = this.futureBanco.get(20, TimeUnit.SECONDS);
			this.saidaCliente.println("Resultado comando c2: "+numeromagico+", "+numeromagico2);
		} catch (Exception e) {
			System.out.println("Timeout: Cancelando execução do comando c2");
			this.saidaCliente.println("Timeout na execução do comando c2");
			this.futureWS.cancel(true);
			this.futureBanco.cancel(true);
		}
		System.out.println("Finalizou JuntaResultadosFutureWSeBanco");
		return null;		
	}

}
