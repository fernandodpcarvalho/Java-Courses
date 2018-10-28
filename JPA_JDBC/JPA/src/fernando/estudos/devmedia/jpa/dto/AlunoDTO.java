package fernando.estudos.devmedia.jpa.dto;

import java.util.Set;

import fernando.estudos.devmedia.jpa.entity.Disciplina;

public class AlunoDTO {
	  private int matricula;
	  private String nome;
	  private String curso;
	  private Set<Disciplina> disciplinas;
	  
	public AlunoDTO(int matricula, String nome, String curso, Set<Disciplina> disciplinas) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
		this.disciplinas = disciplinas;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	  
}
