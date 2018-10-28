package fernando.estudos.alura.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fernando.estudos.alura.bean.Produto;
import fernando.estudos.alura.dao.ConnectionFactory;
import fernando.estudos.alura.dao.ProdutoDAO;

public class TestesProduto {
	public static void main(String[] args) {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			ProdutoDAO pdao = new ProdutoDAO(connection);
			//insereProdutos(pdao);		
			
			listarProdutos(pdao);
						
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void listarProdutos(ProdutoDAO pdao) throws SQLException {
		List<Produto> produtos = pdao.listar();
		System.out.println("Lista de Produtos:");
		System.out.println("ID"+"\t"+"Nome"+"\t\t"+"Descricao");
		for (Produto produto : produtos) {
			System.out.println(produto.toString());
		}
	}

	private static void insereProdutos(ProdutoDAO pdao) throws SQLException {
		Produto p = new Produto();
		
		p.setNome("Geladeira");
		p.setDescricao("Geladeira duas portas");
		pdao.inserir(p);			

		p.setNome("Ferro de passar");
		p.setDescricao("Ferro de passar roupa com vaporizador");
		pdao.inserir(p);

		p.setNome("Notebook");
		p.setDescricao("Notebook i5");
		pdao.inserir(p);

		p.setNome("Mesa azul");
		p.setDescricao("Mesa com 4 pés");
		pdao.inserir(p);

		p.setNome("Mesa vermelha");
		p.setDescricao("Mesa com 4 pés");
		pdao.inserir(p);
	}
	
}