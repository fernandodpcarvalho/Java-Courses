package br.com.alura.deadlock;

public class TarefaAcessaBancoProcedimento implements Runnable {

	private PoolDeConexao pool;
	private GerenciadorDeTransacao tx;

	public TarefaAcessaBancoProcedimento(PoolDeConexao pool, GerenciadorDeTransacao tx) {
		this.pool = pool;
		this.tx = tx;
	}

	@Override
	public void run() {
		
		synchronized (tx) {
			System.out.println("Começando a tx");
			tx.begin();
			
			synchronized (pool) {
				System.out.println("peguei a conexao");
				pool.getConnection();
			}
		}
	}

}
