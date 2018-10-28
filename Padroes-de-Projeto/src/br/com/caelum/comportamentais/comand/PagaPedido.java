package br.com.caelum.comportamentais.comand;

public class PagaPedido implements Comando {

    private Pedido pedido;

    public PagaPedido(Pedido pedido){
        this.pedido = pedido;
    }
    @Override
    public void executa() {
        pedido.paga();
    }

}