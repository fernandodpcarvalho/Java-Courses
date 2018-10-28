package fernando.estudos.outros.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class localDAO {
	public EntityManager getEM(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("EventoPU");
		return factory.createEntityManager();
	}
	
	public void salvar(Local local){ //Insert
		EntityManager em = getEM();
		try {
		em.getTransaction().begin(); //Manualmente por ser SE
		em.persist(local);
		em.getTransaction().commit(); //Manualmente por ser SE
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	
	public Local consultar(Long id) { //Select
		EntityManager em = getEM();
		Local local = null;
		try {
			local = em.find(Local.class, id);
		} finally {
			em.close();
		}
		return local;
	}
	
	public boolean deletar(Local local) {
		EntityManager em = getEM();
		Local l = em.merge(local);
		try {
			em.getTransaction().begin(); //Manualmente por ser SE
			em.remove(l);
			em.getTransaction().commit(); //Manualmente por ser SE
		} catch (Exception e) {
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
		return true;
	}
	
	
	public void atualizar(Local local) {
		EntityManager em = getEM();
		try {
			em.getTransaction().begin(); //Manualmente por ser SE
			em.merge(local);
			em.getTransaction().commit(); //Manualmente por ser SE
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	
	
	
	
	
	
}
