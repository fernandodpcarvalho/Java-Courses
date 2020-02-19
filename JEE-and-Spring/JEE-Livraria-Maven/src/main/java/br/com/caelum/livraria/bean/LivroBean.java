package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.LivroDataModel;
import br.com.caelum.livraria.tx.Transacional;

@Named
@ViewScoped
public class LivroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Livro livro = new Livro();
	private Integer autorId;
	private Integer livroId;
	
	@Inject
	FacesContext context;	
	
	private List<Livro> livros;
	
	@Inject
    private LivroDataModel livroDataModel;
	
	@Inject
	private LivroDao livroDao;
	
	@Inject
	private AutorDao autorDao;	

	public LivroDataModel getLivroDataModel() {
		return livroDataModel;
	}
	public void setLivroDataModel(LivroDataModel livroDataModel) {
		this.livroDataModel = livroDataModel;
	}
	public Integer getLivroId() {
		return livroId;
	}
	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Livro getLivro() {
		return livro;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	public Integer getAutorId() {
		return autorId;
	}

	public List<Livro> getLivros() {
	    if(this.livros == null) {
	        this.livros = livroDao.listaTodos();            
	    }
	    return livros;
	}
	
	public List<Autor> getAutores(){		
		return autorDao.listaTodos();
	}
	
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
	}
	
	@Transacional
	public void gravar() {
	    System.out.println("Gravando livro " + this.livro.getTitulo());

	    if (livro.getAutores().isEmpty()) {
	    	context.addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor."));
	        return;
	    }

	    if(this.livro.getId() == null) {
	        livroDao.adiciona(this.livro);
	        this.livros = livroDao.listaTodos();
	    } else {
	        livroDao.atualiza(this.livro);
	    }

	    this.livro = new Livro();
	}
	
	
	public void gravarAutor(){
		Autor autor = autorDao.buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}
	
	public void removerAutorDoLivro(Autor autor){
		this.livro.removeAutor(autor);
	}
	
	public void comecaComDigitoUm(FacesContext  fc, UIComponent component, Object value) throws ValidatorException {
/*
		String valor = value.toString();
		if(!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deveria começar com 1"));
		}
		*/
	}
	
	public void precoMinMax(FacesContext  fc, UIComponent component, Object value) throws ValidatorException {
		//String valor = value.toString();
		Double valor = (Double) value;
		if(!(valor.doubleValue() >= 1.0 && valor.doubleValue() <=1000.0)) {
			throw new ValidatorException(new FacesMessage("Preço deve ser entre 1,00 e 1000,00"));
		}
		
	}
	
	@Transacional
	public void remover(Livro livro){
		System.out.println("Removendo livro");
		//new DAO<Livro>(Livro.class).remove(livro);
		livroDao.remove(livro);
	}
	
	public void carregar(Livro livro){
		System.out.println("alterar livro");
		//this.livro = livro;
		//Carregar novamente para evitar problema de carregamento lazzy
		this.livro = this.livroDao.buscaPorId(livro.getId());
	}
	
	public String formAutor(){
        System.out.println("Chamanda o formulario do Autor");
        return "autor?faces-redirect=true";
        //return "autor";		
	}
	
	public String formLivro(){
        System.out.println("Chamanda o formulario de livro");
        return "livro?faces-redirect=true";
        //return "livro";		
	}
	
	public void carregarLivroPelaId() {
		//this.livro = new DAO<Livro>(Livro.class).buscaPorId(livroId);
		this.livro = livroDao.buscaPorId(livroId);
	}

	public boolean precoEhMenor(Object valorColuna, Object filtroDigitado, Locale locale) { // java.util.Locale

        //tirando espaços do filtro
        String textoDigitado = (filtroDigitado == null) ? null : filtroDigitado.toString().trim();

        System.out.println("Filtrando pelo " + textoDigitado + ", Valor do elemento: " + valorColuna);

        // o filtro é nulo ou vazio?
        if (textoDigitado == null || textoDigitado.equals("")) {
            return true;
        }

        // elemento da tabela é nulo?
        if (valorColuna == null) {
            return false;
        }

        try {
            // fazendo o parsing do filtro para converter para Double
            Double precoDigitado = Double.valueOf(textoDigitado);
            Double precoColuna = (Double) valorColuna;

            // comparando os valores, compareTo devolve um valor negativo se o value é menor do que o filtro
            return precoColuna.compareTo(precoDigitado) < 0;

        } catch (NumberFormatException e) {

            // usuario nao digitou um numero
            return false;
        }
}
	
	
}
