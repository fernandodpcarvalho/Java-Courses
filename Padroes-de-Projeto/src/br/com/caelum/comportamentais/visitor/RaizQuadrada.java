package br.com.caelum.comportamentais.visitor;

public class RaizQuadrada implements Expressao {

    private Expressao expressao;

    public RaizQuadrada(Expressao expressao) {
		this.expressao = expressao;
    }
    
    public Expressao getExpressao() {
		return expressao;
	}

    @Override
    public int avalia() {
        return (int)Math.sqrt(expressao.avalia());
    }
    
    @Override
    public void aceita(Visitor visitor) {
        visitor.visitaNumero((Numero) this.expressao);
    }
}
