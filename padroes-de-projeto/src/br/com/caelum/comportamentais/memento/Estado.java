package br.com.caelum.comportamentais.memento;

public class Estado {

    private Contrato contrato;

    public Estado(Contrato contrato) {
        this.contrato = contrato;
    }

    public Contrato getContrato() {
        return contrato;
    }

	@Override
	public String toString() {
		return "Estado [contrato=" + contrato.getTipo() + "]";
	}

    
}
