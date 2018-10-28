package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.dao.ProdutoDao;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoDao produtoDao;	
	
	@Autowired
	private FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProdutoValidation());
		
	}
	
	@RequestMapping("form") //Endereço de requisição no browser
	public ModelAndView form(Produto produto){
		ModelAndView modelAndView = new ModelAndView("produtos/form");
		modelAndView.addObject("tipos", TipoPreco.values());
		return modelAndView;
		//return "produtos/form"; //Endereço do formulário form.jsp
	}
	
	@RequestMapping(method=RequestMethod.POST) //Retorno do form.jsp (action)
	@CacheEvict(value="produtosHome", allEntries=true)
	public ModelAndView grava(MultipartFile sumario, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){ //NEsta ordem
		System.out.println(sumario.getOriginalFilename());
		System.out.println(produto);
		
		if(result.hasErrors()) {
			return form(produto);
		}				
		/*C:\Users\Fernando\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\casadocodigo*/
		String path = fileSaver.write("arquivosSumarios", sumario);
		produto.setSumarioPath(path);
		produtoDao.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso!");
		 return new ModelAndView("redirect:produtos");
		
	}	
	
	@RequestMapping(method=RequestMethod.GET) //Retorno do form.jsp (action)
	public ModelAndView listar(){
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;		
	}

	@RequestMapping("/detalhe/{id}")
	public ModelAndView detalhe(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("produtos/detalhe");
		Produto produto = produtoDao.find(id);
		modelAndView.addObject("produto", produto);
		return modelAndView;		
	}
/*	
	@RequestMapping("/{id}")
	@ResponseBody
	public Produto detalheJson(@PathVariable("id") Integer id){
		return produtoDao.find(id);		
	}
	*/
}
