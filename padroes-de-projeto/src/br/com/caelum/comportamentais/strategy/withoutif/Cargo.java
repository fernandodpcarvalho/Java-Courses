package br.com.caelum.comportamentais.strategy.withoutif;

public enum Cargo implements Comissao {
	 
    ATENDENTE {
         @Override
         public double calculaComissao(double valor) {
              return valor * 0.1;
         }
    },
    VENDEDOR {
         @Override
         public double calculaComissao(double valor) {
              return valor * 0.15 + 5;
         }
    },
    GERENTE {
         @Override
         public double calculaComissao(double valor) {
              return valor * 0.20 + 10;
         }
    },
    AJUDANTE {
   @Override
         public double calculaComissao(double valor) {
              return valor * 0.08 + 1;
         }
    },
    RECEPCIONISTA {
         @Override
         public double calculaComissao(double valor) {
              return valor * 0.05;
         }
    },
    DIRETOR {
         @Override
         public double calculaComissao(double valor) {
              return valor * 0.25 + 20;
         }
    };
 
}
