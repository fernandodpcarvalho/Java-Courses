package fernando.estudos.devmedia.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor {

    @Id
    private int registro;
    private String nome;
    private String departamento;

    public Professor(int registro, String nome, String departamento) {
        this.registro = registro;
        this.nome = nome;
        this.departamento = departamento;
    }

    public Professor() {

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

    @Override
    public String toString() {
        return "Professor [registro=" + registro + ", nome=" + nome
                + ", departamento=" + departamento + "]";
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}