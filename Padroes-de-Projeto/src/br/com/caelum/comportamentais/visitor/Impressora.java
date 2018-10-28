package br.com.caelum.comportamentais.visitor;

public class Impressora implements Visitor  {

    public void visitaSoma(Soma soma) {
        System.out.print("(");
        soma.getEsquerda().aceita(this);
        System.out.print(" + ");
        soma.getDireita().aceita(this);
        System.out.print(")");

    }

    public void visitaSubtracao(Subtracao subtracao) {
        System.out.print("(");
        subtracao.getEsquerda().aceita(this);
        System.out.print(" - ");
        subtracao.getDireita().aceita(this);
        System.out.print(")");
    }

    public void visitaNumero(Numero numero) {
        System.out.print(numero.getNumero());

    }

	public void visitaMultiplicacao(Multiplicacao multiplicacao) {
        System.out.print("(");
        multiplicacao.getEsquerda().aceita(this);
        System.out.print(" * ");
        multiplicacao.getDireita().aceita(this);
        System.out.print(")");		
	}

	public void visitaDivisao(Divisao divisao) {
        System.out.print("(");
        divisao.getEsquerda().aceita(this);
        System.out.print(" / ");
        divisao.getDireita().aceita(this);
        System.out.print(")");		
	}
}