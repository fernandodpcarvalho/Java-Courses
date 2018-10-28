package br.com.caelum.comportamentais.visitor;

public class TestaExpressao {

    public static void main(String[] args) {
    	Expressao esquerda = new Subtracao(new Numero(10), new Numero(5));
    	Expressao direita = new Soma(new Numero(10), new Numero(2));
    	Expressao conta = new Soma(esquerda, direita);
    	
    	Visitor impressora = new Impressora();
        conta.aceita(impressora);
        System.out.println(" = "+conta.avalia());
        
        
    	esquerda = new Multiplicacao(new Numero(10), new Numero(5));
    	direita = new Divisao(new Numero(10), new Numero(2));
    	conta = new Soma(esquerda, direita);
    	conta.aceita(impressora);
        System.out.println(" = "+conta.avalia());
        
        
    }
}
