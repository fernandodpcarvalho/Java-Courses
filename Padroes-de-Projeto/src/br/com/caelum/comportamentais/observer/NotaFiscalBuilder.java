package br.com.caelum.comportamentais.observer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotaFiscalBuilder {
	private String razaoSocial;
	private String cnpj;
	private double impostos;
	private Calendar data;
	private String observacoes;
	private double valorBruto;

	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	
	//Lista com as ações a serem executadas - Padrão Observer
	List<AcaoAposGerarNota> todasAcoesASeremExecutadas = new ArrayList<AcaoAposGerarNota>();

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this; // retorno eu mesmo, o próprio builder, para que o cliente continue utilizando
	}

	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		return this;
	}

	public NotaFiscalBuilder comItem(ItemDaNota item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}
	
	public NotaFiscalBuilder comObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
      }

      public NotaFiscalBuilder naDataAtual() {
        this.data = Calendar.getInstance();
        return this;
      }

	public NotaFiscal constroi() {
		NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, cnpj, data, valorBruto, impostos, todosItens, observacoes);
		
		//Padrão observer: Executa as ações cadastradas
		for(AcaoAposGerarNota acao : todasAcoesASeremExecutadas) {
	          acao.executa(notaFiscal);
		}
		
		return notaFiscal;
	}
	
    public void adicionaAcao(AcaoAposGerarNota novaAcao) {
        this.todasAcoesASeremExecutadas.add(novaAcao);
      }
}