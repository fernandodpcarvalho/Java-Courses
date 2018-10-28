package fernando.estudos.devmedia.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fernando.estudos.devmedia.jpa.entity.Professor;
import fernando.estudos.devmedia.jpa.exception.PersistenciaException;

public class ProfessorDAO implements GenericoDAO<Professor> {
	public EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Escola");
		return factory.createEntityManager();
	}

	@Override
	public void inserir(Professor obj) throws PersistenciaException {
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin(); // Manualmente por ser SE
			em.persist(obj);
			em.getTransaction().commit(); // Manualmente por ser SE
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		
	}

	@Override
	public void atualizar(Professor obj) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Professor> listar() throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professor buscaPorId(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
