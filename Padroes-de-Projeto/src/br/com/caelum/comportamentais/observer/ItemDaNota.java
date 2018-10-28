package br.com.caelum.comportamentais.observer;

public class ItemDaNota {
    private String descricao;
    private double valor;

    public ItemDaNota(String descricao, double valor) {
      this.descricao = descricao;
      this.valor = valor;
    }

    public double getValor() {
      return this.valor;
    }

    public String getDescricao() {
      return this.descricao;
    }

	@Override
	public String toString() {
		return "ItemDaNota [descricao=" + descricao + ", valor=" + valor + "]";
	}
    
  }