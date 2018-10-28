package br.com.caelum.comportamentais.template_method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Representa um orcamento. Há descontos por valor e por quantidade de itens 
public class Orcamento {

	private double valor;
	private List<Item> itens = new ArrayList<Item>();

	public double getValor() {
		return valor;
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public void adicionaItem(Item item) {
		itens.add(item);
		this.valor += item.getValor();
	}

}