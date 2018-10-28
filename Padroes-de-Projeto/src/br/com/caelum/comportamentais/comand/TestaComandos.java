package br.com.caelum.comportamentais.comand;

public class TestaComandos {

    public static void main(String[] args) {
        Pedido pedido1 = new Pedido("Mauricio", 150.0);
        Pedido pedido2 = new Pedido("Marcelo", 250.0);

        FilaDeTrabalho fila = new FilaDeTrabalho();

        fila.adiciona(new PagaPedido(pedido1));
        fila.adiciona(new ConcluiPedido(pedido1));
        fila.adiciona(new PagaPedido(pedido2));
        fila.adiciona(new ConcluiPedido(pedido2));
        fila.processa();
    }
}
