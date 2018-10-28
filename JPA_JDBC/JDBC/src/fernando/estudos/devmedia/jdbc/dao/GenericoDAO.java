package fernando.estudos.devmedia.jdbc.dao;

import java.util.List;

import fernando.estudos.devmedia.jdbc.exception.PersistenciaException;

public interface GenericoDAO<T> { //faz uso de genéricos	
	
	void inserir(T obj) throws PersistenciaException;
	
	void atualizar(T obj) throws PersistenciaException;
	
	void deletar(Integer id) throws PersistenciaException;
	
	List<T> listar() throws PersistenciaException;
	
	T buscaPorId(Integer id) throws PersistenciaException;
	

}
