package fernando.estudos.outros.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Local {
	@Id
	private Long id;
	private String predio;
	private String sala;
	private int capacidade;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPredio() {
		return predio;
	}
	public void setPredio(String predio) {
		this.predio = predio;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	

}
