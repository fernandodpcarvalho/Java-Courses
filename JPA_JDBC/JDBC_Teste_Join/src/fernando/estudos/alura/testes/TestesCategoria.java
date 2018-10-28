package fernando.estudos.alura.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fernando.estudos.alura.bean.Categoria;
import fernando.estudos.alura.dao.ConnectionFactory;
import fernando.estudos.alura.dao.CategoriaDAO;

public class TestesCategoria {
	public static void main(String[] args) {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			CategoriaDAO cdao = new CategoriaDAO(connection);
			//insereCategorias(cdao);
			
			listarCategorias(cdao);
	
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void listarCategorias(CategoriaDAO cdao) throws SQLException {
		System.out.println("Lista de Categorias:");
		System.out.println("ID"+"\t"+"Nome");
		List<Categoria> categorias = cdao.listar();
		for (Categoria categoria : categorias) {
			System.out.println(categoria.toString());
		}
	}

	private static void insereCategorias(CategoriaDAO cdao) throws SQLException {
		Categoria c = new Categoria();
		
		c.setNome("Eletrodoméstico");
		cdao.inserir(c);			

		c.setNome("Eletrônico");
		cdao.inserir(c);

		c.setNome("Móvel");
		cdao.inserir(c);
	}
	
}