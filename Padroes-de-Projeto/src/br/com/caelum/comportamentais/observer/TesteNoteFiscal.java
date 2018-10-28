package br.com.caelum.comportamentais.observer;

public class TesteNoteFiscal {

	public static void main(String[] args) {
		
		ItemDaNota item = new ItemDaNotaBuilder()
				.comDescricao("Item 1")
				.comValor(100.0)
				.constroi();
		
		System.out.println(item);
		
		System.out.println("\n\n");
		
		NotaFiscalBuilder builder = new NotaFiscalBuilder();
        builder.adicionaAcao(new EnviadorDeEmail());
        builder.adicionaAcao(new NotaFiscalDao());
        builder.adicionaAcao(new EnviadorDeSms());
        builder.adicionaAcao(new Impressora());
		

		NotaFiscal nf = builder.paraEmpresa("Caelum")
				.comCnpj("123.456.789/0001-10")
				.comItem(new ItemDaNota("item 1", 100.0))
				.comItem(new ItemDaNota("item 2", 200.0))
				.comItem(new ItemDaNota("item 3", 300.0))
				.comObservacoes("entregar nf pessoalmente")
				.naDataAtual()
				.constroi();

		System.out.println(nf);
	}
}