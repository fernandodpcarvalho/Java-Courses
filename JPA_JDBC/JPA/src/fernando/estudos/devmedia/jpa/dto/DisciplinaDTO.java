package fernando.estudos.devmedia.jpa.dto;

import fernando.estudos.devmedia.jpa.entity.DiaDaSemana;
import fernando.estudos.devmedia.jpa.entity.Professor;

public class DisciplinaDTO {
	  private Long id;
	  private String sigla;
	  private String nome;
	  private DiaDaSemana diaDaSemana;
	  private Integer horaInicio;
	  private Integer horaFim;
	  private Professor professor;
	  
	public DisciplinaDTO(Long id, String sigla, String nome, DiaDaSemana diaDaSemana, Integer horaInicio,
			Integer horaFim, Professor professor) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.diaDaSemana = diaDaSemana;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public Integer getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Integer horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Integer getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Integer horaFim) {
		this.horaFim = horaFim;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
}
