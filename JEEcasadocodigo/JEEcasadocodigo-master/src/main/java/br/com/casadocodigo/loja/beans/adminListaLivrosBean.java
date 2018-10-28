package br.com.casadocodigo.loja.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

//CDI = Anotação que conecta o Bean à tela. 
//O nome default de referência para a tela é o nome da classe com a primeira letra em minúscula 
//Esta anotação equivale a @Named + @RequestBean
@Model
public class adminListaLivrosBean {

	@Inject
	private LivroDao livroDao;
	
	private List<Livro> livros = new ArrayList<>();

	public List<Livro> getLivros() {
		this.livros = livroDao.listar();
		return this.livros;
	}	

}
