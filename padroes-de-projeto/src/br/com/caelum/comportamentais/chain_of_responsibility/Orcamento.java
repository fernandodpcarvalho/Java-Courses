package br.com.caelum.comportamentais.chain_of_responsibility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Representa um orcamento. Há descontos por valor e por quantidade de itens 
public class Orcamento {

    private double valor;
    private List<Item> itens = new ArrayList<Item>();
    
/*   
    private List<Item> itens;

    public Orcamento(double valor) {
        this.valor = valor;
        this.itens = new ArrayList<Item>();
    }
*/
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
    
    public boolean existe(String nomeDoItem, Orcamento orcamento) {
        for (Item item : orcamento.getItens()) {
            if(item.getNome().equals(nomeDoItem)) return true;
        }
        return false;
    }

}