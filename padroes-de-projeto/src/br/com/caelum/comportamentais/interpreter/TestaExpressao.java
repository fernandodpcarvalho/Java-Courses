package br.com.caelum.comportamentais.interpreter;

public class TestaExpressao {

    public static void main(String[] args) {

        Expressao esquerda = new Subtracao(new Numero(10), new Numero(5));
        Expressao direita = new Soma(new Numero(2), new Numero(10));

        Expressao conta = new Soma(esquerda, direita);

        int resultado = conta.avalia();
        System.out.println(resultado);
        
        esquerda = new Multiplicacao(new Numero(5), new Numero(3));
        direita  = new Divisao(new Numero(20), new Numero(4));
        
        System.out.println(new Soma(esquerda, direita).avalia());

        System.out.println(new Divisao(new Numero(10), new Numero(2)).avalia());
        
        System.out.println(new RaizQuadrada(new Numero(16)).avalia());
        
        //System.out.println(new Divisao(new Numero(10), new Numero(0)).avalia());
    }
}
