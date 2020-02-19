package br.com.casadocodigo.loja.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.ProdutoDao;
import br.com.casadocodigo.loja.dao.UsuarioDao;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.Role;
/*
 * A implementação desta classe por si só não faz com que receba as requisiçoes.
 * É necessário informar ao servidor para que encaminhe as requisições pra cá
 * Isso pode ser feito por xml ou criando uma classe que estenda AbstractAnnotationConfigDispatcherServletInitializer
 */
import br.com.casadocodigo.loja.models.Usuario;

@Controller
public class HomeController {
	
	@Autowired
	private ProdutoDao dao;
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping("/") //Define a URL que quando for requisitada chamará o método abaixo
	@Cacheable(value="produtosHome")
	public ModelAndView index(){
		
		List<Produto> produtos = dao.listar();
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
		//System.out.println("Entrando na home da casa do código!");
		//return "home";
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping("/howmanyisfive")
	public String urlMagicaMaluca() {
	    Usuario usuario = new Usuario(); 
	    usuario.setNome("Admin");
	    usuario.setEmail("admin@casadocodigo.com.br");
	    usuario.setSenha("$2a$10$lt7pS7Kxxe5JfP.vjLNSyOXP11eHgh7RoPxo5fvvbMCZkCUss2DGu");
	    usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));

	    usuarioDao.gravar(usuario);

	    return "Url Mágica executada";
	}
	
	
}

