package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.tx.Transacional;

@Named
@ViewScoped 
public class AutorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Autor autor = new Autor();
	
	private Integer autorId;

	private List<Autor> autores;
	
	@Inject
	private AutorDao dao;	
	
	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
	public void carregarAutorPelaId() {
		this.autor = dao.buscaPorId(autorId);
	}

	public Autor getAutor() {
		return autor;
	}

	@Transacional 
	public void gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());
				
		if(this.autor.getId() == null) {
	        dao.adiciona(this.autor);
	        this.autores = dao.listaTodos();
	    } else {
	        dao.atualiza(this.autor);
	    }		
		
		//o modelo devolve o valor de autor para a view, e por isso a entrada digirada permanece no input.
		//Para "limpar" o input, criar novo objeto vazio.
		this.autor = new Autor();
	}

	public List<Autor> getAutores(){		
	    if(this.autores == null) {
	        this.autores = dao.listaTodos();            
	    }
	    return autores;	
	}
	
	@Transacional
	public void remover(Autor autor){
		dao.remove(autor);
	}
	
	public void carregar(Autor autor){
		System.out.println("alterar autor");
		this.autor = autor;
	}
}
