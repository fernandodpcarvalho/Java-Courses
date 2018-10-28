package fernando.estudos.devmedia.jpa.dao;

import java.util.List;

import fernando.estudos.devmedia.jpa.exception.PersistenciaException;

public interface GenericoDAO<T> {	
	
	void inserir(T obj) throws PersistenciaException;
	
	void atualizar(T obj) throws PersistenciaException;
	
	void deletar(Integer id) throws PersistenciaException;
	
	List<T> listar() throws PersistenciaException;
	
	T buscaPorId(Integer id) throws PersistenciaException;
	

}
