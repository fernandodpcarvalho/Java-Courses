package fernando.estudos.devmedia.jpa.dto;

public class ProfessorDTO {
    private int registro;
    private String nome;
    private String departamento;
	public ProfessorDTO(int registro, String nome, String departamento) {
		super();
		this.registro = registro;
		this.nome = nome;
		this.departamento = departamento;
	}
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}    
}
