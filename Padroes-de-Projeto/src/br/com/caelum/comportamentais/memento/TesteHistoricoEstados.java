package br.com.caelum.comportamentais.memento;

import java.util.Calendar;

public class TesteHistoricoEstados {

    public static void main(String[] args) {

        Historico historico = new Historico();

        Contrato contrato = new Contrato(Calendar.getInstance(), "Mauricio", TipoContrato.NOVO);
        historico.adiciona(contrato.salvaEstado());

        contrato.avanca();
        historico.adiciona(contrato.salvaEstado());

        contrato.avanca();
        historico.adiciona(contrato.salvaEstado());

        contrato.avanca();
        historico.adiciona(contrato.salvaEstado());
        
        System.out.println(historico.pega(0));
        System.out.println(historico.pega(1));
        System.out.println(historico.pega(2));
        System.out.println(historico.pega(3));

        contrato.restaura(historico.pega(1));
        System.out.println(contrato.getTipo());
    }

}
