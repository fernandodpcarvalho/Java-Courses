package fernando.estudos.devmedia.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fernando.estudos.devmedia.jdbc.dao.ConexaoDAO;
import fernando.estudos.devmedia.jdbc.dto.AuthorDTO;
import fernando.estudos.devmedia.jdbc.exception.PersistenciaException;

public class AuthorDAO implements GenericoDAO<AuthorDTO> {

	@Override
	public void inserir(AuthorDTO authorDTO) throws PersistenciaException {		
		try {
			Connection connection = ConexaoDAO.getInstance().getConnection();
			String sql = "INSERT INTO authors (authorID, firstName, lastName) "+
					     "VALUES(?, ?, ?)"; //Técnica para melhorar o código e evitar sqlinject (segurança).
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, authorDTO.getAuthorID());
			statement.setString(2, authorDTO.getFirstName());
			statement.setString(3, authorDTO.getLastname());
			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		} 
	}

	@Override
	public void atualizar(AuthorDTO authorDTO) throws PersistenciaException {
		try {
			Connection connection = ConexaoDAO.getInstance().getConnection();
			String sql = "UPDATE authors SET " +
		                 "firstName = ?, " +
		                 "lastName = ? " +
					     "WHERE authorID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, authorDTO.getFirstName());
			statement.setString(2, authorDTO.getLastname());
			statement.setInt(3, authorDTO.getAuthorID());
			statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
	}

	@Override
	public void deletar(Integer id) throws PersistenciaException {
		try {
			Connection connection = ConexaoDAO.getInstance().getConnection();
			String sql = "DELETE FROM authors " +
			             "WHERE authorID = ?";
		    PreparedStatement statement = connection.prepareStatement(sql);
		    statement.setInt(1, id);
		    statement.execute();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		} 
	}

	@Override
	public List<AuthorDTO> listar() throws PersistenciaException {
		try {
			List<AuthorDTO> listaAuthors = new ArrayList<AuthorDTO>();
			Connection connection = ConexaoDAO.getInstance().getConnection();
			String sql = "select * from authors";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery(); //usado mais em selects, pois retorna um resultset
			while (resultset.next()) {
				AuthorDTO authorDTO = new AuthorDTO();
				authorDTO.setAuthorID(resultset.getInt("authorID"));
				authorDTO.setFirstName(resultset.getString("firstName"));
				authorDTO.setLastname(resultset.getString("lastname"));
				listaAuthors.add(authorDTO);
				}
			connection.close(); //Fecha a conexão
			return  listaAuthors;
		} catch(Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		} 
	}

	@Override
	public AuthorDTO buscaPorId(Integer id) throws PersistenciaException {
		try {
			Connection connection = ConexaoDAO.getInstance().getConnection();
			String sql = "select * from authors where authorID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			AuthorDTO authorDTO = new AuthorDTO();
			if (resultSet.next()) { //POde haver nenhum resultado
				authorDTO.setAuthorID(resultSet.getInt("authorID"));
				authorDTO.setFirstName(resultSet.getString("firstName"));
				authorDTO.setLastname(resultSet.getString("lastName"));	
			}			
			connection.close();
			return authorDTO;
		} catch (Exception e) {
			throw new PersistenciaException(e.getMessage(), e);
		}
	}
	
	
	/******************************************************************/
	public int obterMaxID() throws PersistenciaException {
		try {
			int maxID = 0;
			Connection connection = ConexaoDAO.getInstance().getConnection();
			String sql = "SELECT MAX(authorID) FROM authors";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultset = statement.executeQuery();
			resultset.next();
			maxID = resultset.getInt(1);
			return maxID;
		} catch (Exception e) {
			throw new PersistenciaException(e.getMessage(), e);
		}		
	}	
	
}
