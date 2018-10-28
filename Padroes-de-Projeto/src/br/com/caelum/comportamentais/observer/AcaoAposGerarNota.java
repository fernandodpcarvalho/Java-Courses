package br.com.caelum.comportamentais.observer;

public interface AcaoAposGerarNota {
	void executa(NotaFiscal notaFiscal);
}

class EnviadorDeEmail implements AcaoAposGerarNota {

	public void executa(NotaFiscal notaFiscal) {
		System.out.println("enviando por e-mail");
	}
}

class NotaFiscalDao implements AcaoAposGerarNota {
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("salvando no banco");
	}
}

class EnviadorDeSms implements AcaoAposGerarNota {
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("enviando por sms");
	}
}

class Impressora implements AcaoAposGerarNota {
	public void executa(NotaFiscal notaFiscal) {
		System.out.println("imprimindo notaFiscal");
	}
}
