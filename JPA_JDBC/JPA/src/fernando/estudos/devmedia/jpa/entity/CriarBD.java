package fernando.estudos.devmedia.jpa.entity;

import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarBD {

  public static void main(String[] args) {
   EntityManagerFactory emf = Persistence
   .createEntityManagerFactory("Escola");
   EntityManager em = emf.createEntityManager();
   em.getTransaction().begin();

   Professor professor1 = new Professor(1, "Bill Gates", "Computação");
   em.persist(professor1);
   Professor professor2 = new Professor(2, "Oswald de Souza", 
   "Matemática");
   em.persist(professor2);
   Professor professor3 = new Professor(3, "Cesar Lattes", "Física");
   em.persist(professor3);

   Disciplina disciplina1 = new Disciplina("MA-100", "Cálculo 1",
   DiaDaSemana.SEGUNDA, 8, 10, professor2);
   em.persist(disciplina1);
   Disciplina disciplina2 = new Disciplina("MA-100", "Cálculo 1",
   DiaDaSemana.QUARTA, 8, 10, professor2);
   em.persist(disciplina2);
   Disciplina disciplina3 = new Disciplina("CC-100", "Algoritmos",
   DiaDaSemana.QUARTA, 10, 12, professor1);
   em.persist(disciplina3);
   Disciplina disciplina4 = new Disciplina("F-100", "Física 1",
   DiaDaSemana.QUINTA, 14, 16, professor3);
   em.persist(disciplina4);

   HashSet<Disciplina> grade1 = new HashSet<Disciplina>();
   grade1.add(disciplina2);
   grade1.add(disciplina3);
   grade1.add(disciplina4);
   HashSet<Disciplina> grade2 = new HashSet<Disciplina>();
   grade2.add(disciplina1);
   grade2.add(disciplina2);
   grade2.add(disciplina3);
   Aluno aluno1 = new Aluno(20130001, "Adriano", "Algoritmos", grade1);
   em.persist(aluno1);
   Aluno aluno2 = new Aluno(20130002, "Felipe", "Cálculo 1", grade1);
   em.persist(aluno2);
   Aluno aluno3 = new Aluno(20130003, "Mariana", "Física 1", grade2);
   em.persist(aluno3);
   Aluno aluno4 = new Aluno(20130004, "Rodrigo", "Computação", grade2);
   em.persist(aluno4);
 
   em.getTransaction().commit();
   em.close();
   emf.close();
  }
}
