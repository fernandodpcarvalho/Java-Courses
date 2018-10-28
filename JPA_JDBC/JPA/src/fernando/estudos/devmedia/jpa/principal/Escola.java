package fernando.estudos.devmedia.jpa.principal;

import java.util.HashSet;
import java.util.Set;

import fernando.estudos.devmedia.jpa.dao.AlunoDAO;
import fernando.estudos.devmedia.jpa.dao.DisciplinaDAO;
import fernando.estudos.devmedia.jpa.dao.ProfessorDAO;
import fernando.estudos.devmedia.jpa.entity.Aluno;
import fernando.estudos.devmedia.jpa.entity.DiaDaSemana;
import fernando.estudos.devmedia.jpa.entity.Disciplina;
import fernando.estudos.devmedia.jpa.entity.Professor;
import fernando.estudos.devmedia.jpa.exception.PersistenciaException;

public class Escola {
	
	public static void main(String[] args) throws PersistenciaException {
		Aluno aluno;
		Professor professor;
		Disciplina disciplina;
		HashSet<Disciplina> grade = new HashSet<Disciplina>();

		//Teste inserção		
		professor = new Professor(5, "Marcos Chain", "Engenharia de Software");
		ProfessorDAO p = new ProfessorDAO();
		p.inserir(professor);
		//
		disciplina = new Disciplina("FF-200", "Estatística", DiaDaSemana.QUARTA, 8, 10, professor);
		DisciplinaDAO d = new DisciplinaDAO();
		d.inserir(disciplina);
		//
		grade.add(disciplina);
		aluno = new Aluno(20130005, "Fernando Carvalho", "Engenharia", grade);
		AlunoDAO a = new AlunoDAO();
		a.inserir(aluno);
	}

}
