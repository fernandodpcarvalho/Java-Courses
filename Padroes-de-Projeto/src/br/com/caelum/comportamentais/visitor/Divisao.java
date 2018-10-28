package br.com.caelum.comportamentais.visitor;

public class Divisao implements Expressao {

    private Expressao esquerda;
    private Expressao direita;

    public Divisao(Expressao esquerda, Expressao direita) {
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public Expressao getEsquerda() {
		return esquerda;
	}
    
	public Expressao getDireita() {
		return direita;
	}

	@Override
    public int avalia() {
        int resultadoDaEsquerda = esquerda.avalia();
        int resultadoDaDireita = direita.avalia();
        if(resultadoDaDireita > 0) return resultadoDaEsquerda / resultadoDaDireita;
        else throw new RuntimeException("Não pode divisão por zero");
    }
    

    @Override
    public void aceita(Visitor visitor) {
        visitor.visitaDivisao(this);
    }
}
