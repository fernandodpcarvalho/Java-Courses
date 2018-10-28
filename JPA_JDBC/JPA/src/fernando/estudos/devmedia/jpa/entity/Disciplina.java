package fernando.estudos.devmedia.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Disciplina {

 //public enum DiaDaSemana { SEGUNDA, TERÇA, QUARTA, QUINTA, SEXTA };

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String sigla;
  private String nome;

  @Enumerated(EnumType.STRING)
  private DiaDaSemana diaDaSemana;
  private Integer horaInicio;
  private Integer horaFim;

  @ManyToOne
  private Professor professor;

  public Disciplina() {
  }

  public Disciplina(String sigla, String nome, DiaDaSemana diaDaSemana,
   Integer horaInicio, Integer horaFim, Professor professor) {
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

  @Override
  public String toString() {
   return "Disciplina [id=" + id + ", sigla=" + sigla + ", nome=" + nome
  + ", diaDaSemana=" + diaDaSemana 
  + ", horaInicio=" + horaInicio
  + ", horaFim=" + horaFim 
  + ", professor=" + professor + "]";
  }
}