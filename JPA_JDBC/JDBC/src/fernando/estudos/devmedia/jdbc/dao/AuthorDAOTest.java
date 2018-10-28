package fernando.estudos.devmedia.jdbc.dao;

import java.util.List;

import fernando.estudos.devmedia.jdbc.dto.AuthorDTO;

public class AuthorDAOTest {

	public void imprimeNaTela(List<AuthorDTO> listAuthorDTO) {		
		System.out.printf("%-8s\t%-8s\t%-8s\t\n", "authorID", "firstname", "lastname");
		for(int i=0;i<listAuthorDTO.size();i++) {
			AuthorDTO authorDTO = listAuthorDTO.get(i);
			System.out.printf("%-8s\t%-8s\t%-8s\t\n", authorDTO.getAuthorID(), authorDTO.getFirstName(), authorDTO.getLastname());
		}
	}
	
	public void imprimeNaTela(AuthorDTO authorDTO) {		
		System.out.printf("%-8s\t%-8s\t%-8s\t\n%-8s\t%-8s\t%-8s\t\n", "authorID", "firstname", "lastname", authorDTO.getAuthorID(), authorDTO.getFirstName(), authorDTO.getLastname());
	}	
		
	public static void main(String[] args) {
		AuthorDAOTest adt = new AuthorDAOTest();
		AuthorDAO authorDAO = new AuthorDAO();
		try {
			adt.imprimeNaTela(authorDAO.listar()); 
			authorDAO.inserir(new AuthorDTO(authorDAO.obterMaxID() + 1, "Francisco", "Carvalho"));
			adt.imprimeNaTela(authorDAO.listar());
			authorDAO.atualizar(new AuthorDTO(8, "Amanda", "Maia"));
			adt.imprimeNaTela(authorDAO.listar());
			authorDAO.deletar(authorDAO.obterMaxID());
			adt.imprimeNaTela(authorDAO.listar());
			adt.imprimeNaTela(authorDAO.buscaPorId(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
