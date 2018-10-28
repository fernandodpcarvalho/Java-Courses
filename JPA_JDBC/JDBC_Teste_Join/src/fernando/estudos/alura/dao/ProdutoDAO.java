package fernando.estudos.alura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fernando.estudos.alura.bean.Produto;

public class ProdutoDAO {
	Connection connection = null;
	
	public ProdutoDAO(Connection connection) {
		this.connection = connection;
	}
	
	public List<Produto> listar() throws SQLException {
		List<Produto> produtos = new ArrayList<Produto>();
		String sql = "select * from Caelum.Produtos";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Produto p = new Produto();
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setDescricao(rs.getString("descricao"));
			produtos.add(p);
		}
		return produtos;
	}
	
	
	public void inserir(Produto produto) throws SQLException {
		String sql = "insert into Caelum.Produtos"+"(nome, descricao)"+" values (?, ?)";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, produto.getNome());
		stmt.setString(2, produto.getDescricao());
		stmt.execute();
		stmt.close();
		
	}
}
