package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Livro;

public class LivroDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
    EntityManager em;

    private DAO<Livro> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Livro>(this.em, Livro.class);
    }
	
	
	public List<Livro> listaTodos() {
		return this.dao.listaTodos();
	}

	public void adiciona(Livro livro) {
		this.dao.adiciona(livro);
		
	}

	public void atualiza(Livro livro) {
		this.dao.atualiza(livro);
	}

	public Livro buscaPorId(Integer livroId) {
		return this.dao.buscaPorId(livroId);
	}

	public void remove(Livro livro) {
		this.dao.remove(livro);
	}


	public int quantidadeDeElementos() {
		return this.dao.quantidadeDeElementos();
	}


	public List<Livro> listaTodosPaginada(int inicio, int quantidade) {
		return this.dao.listaTodosPaginada(inicio, quantidade);
	}

}
