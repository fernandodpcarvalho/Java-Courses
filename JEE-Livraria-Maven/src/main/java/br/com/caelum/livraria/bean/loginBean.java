package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;
import br.com.caelum.livraria.util.RedirectView;

@Named
@ViewScoped
public class loginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioDao dao;
	
	@Inject
	FacesContext context;
	
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public RedirectView efetuarLogin(){
		System.out.println("Fazendo login do usuário"+this.usuario.getEmail());
		
		boolean existe = dao.existe(this.usuario);
		
		if(existe) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);

			return new RedirectView("livro");
		} 
		
		//O retorno com redirect força uma nova requisição, o context é apagado e perde a mensagem cadastrada.
		//Para resolver isso, o getFash faz com que o context continue válido por mais uma requisição.
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Usuario ou sennha inválidos"));
		return new RedirectView("login");
	}
	
	public String deslogar(){
		context.getExternalContext().getSessionMap().remove("usuarioLogado");		
		return "login?faces-redirect=true";
	}
}
