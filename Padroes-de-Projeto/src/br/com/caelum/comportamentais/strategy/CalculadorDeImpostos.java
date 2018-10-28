package br.com.caelum.comportamentais.strategy;

//Recebe um orcamento e aplica um calculo de imposto usando polimorfismo
public class CalculadorDeImpostos {

	//Método que recebe um tipo Imposto, cuja implementação será identificada em tempo de execução 
    public void realizaCalculo(Orcamento orcamento, Imposto imposto) {

      double valor = imposto.calcula(orcamento); 

      System.out.println(valor);

    }

}




//IMPLEMENTAÇÃO RUIM USANDO CONDICIONAIS
/*
public class CalculadorDeImpostos {

    public void realizaCalculo(Orcamento orcamento, String imposto) {

    if( "ICMS".equals(imposto) ) {

      double icms = orcamento.getValor() * 0.1;
      System.out.println(icms); // imprimirá 50.0

    } else if( "ISS".equals(imposto) ) {

      double iss = orcamento.getValor() * 0.06;
      System.out.println(iss); // imprimirá 30.0

      }
    }
}
*/