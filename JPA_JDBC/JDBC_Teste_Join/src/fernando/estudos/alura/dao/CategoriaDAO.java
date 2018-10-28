package fernando.estudos.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fernando.estudos.alura.bean.Categoria;

public class CategoriaDAO {
	Connection connection = null;
	
	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Categoria> listar() throws SQLException {
		List<Categoria> Categorias = new ArrayList<Categoria>();
		String sql = "select * from Caelum.Categorias";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Categoria c = new Categoria();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			Categorias.add(c);
		}
		return Categorias;
	}
	
	
	public void inserir(Categoria Categoria) throws SQLException {
		String sql = "insert into Caelum.Categorias"+"(nome)"+" values (?)";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, Categoria.getNome());
		stmt.execute();
		stmt.close();
		
	}
}
