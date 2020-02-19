package br.com.caelum.livraria.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.livraria.dao.LivroDao;

@ViewScoped
public class LivroDataModel extends LazyDataModel<Livro> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	LivroDao dao;
	
	@PostConstruct
    void init() {
        super.setRowCount(dao.quantidadeDeElementos());
    }
	
	@Override
	public List<Livro> load(int inicio, int quantidade, String campoOrdenacao, SortOrder sentidoOrdenacao, Map<String, Object> filtros) {
		 return dao.listaTodosPaginada(inicio, quantidade);
	}

}
