package br.com.caelum.comportamentais.comand;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Pedido {

    private String cliente;
    private double valor;
    private Status status;
    private Calendar dataFinalizacao;

    public Pedido(String cliente, double valor) {
        this.cliente = cliente;
        this.valor = valor;

        System.out.println("Novo "+this);
    }

    public void paga() {
        status = Status.PAGO;
        System.out.println(this);
    }

    public void finaliza() {
        dataFinalizacao = Calendar.getInstance();
        status = Status.ENTREGUE;
        System.out.println(this);
    }

	@Override
	public String toString() {
		if (this.dataFinalizacao != null) {
		return "Pedido [cliente=" + cliente + ", valor=" + valor + ", status=" + status + ", dataFinalizacao="
				+ new SimpleDateFormat("dd/MM/yyyy").format(dataFinalizacao.getTime()) + "]";
		} else {
			return "Pedido [cliente=" + cliente + ", valor=" + valor + ", status=" + status + ", dataFinalizacao="
					+ dataFinalizacao + "]";
		}
	}
    
    
    
}