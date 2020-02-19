package br.com.casadocodigo.loja.dao;

import javax.servlet.Filter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.casadocodigo.loja.conf.AppWebConfiguration;
import br.com.casadocodigo.loja.conf.DataSourceConfigurationTest;
import br.com.casadocodigo.loja.conf.JPAConfiguration;
import br.com.casadocodigo.loja.conf.SecurityConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAConfiguration.class, AppWebConfiguration.class, DataSourceConfigurationTest.class,
		SecurityConfiguration.class })
@ActiveProfiles("test")
public class ProdutosControllerTest {

	@Autowired
	private WebApplicationContext wac;

	// Faz as requisições aos controllers
	private MockMvc mockMvc; 
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Autowired
    private Filter springSecurityFilterChain;
	
	@Before
	public void setup2() {
        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).addFilter(filter, urlPatterns)  (springSecurityFilterChain).build();
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
        		.addFilter(springSecurityFilterChain).build();
	}

	@Test
	public void deveRetornarParaHomeComOsLivros() throws Exception {
		// Método que simula uma requisição
		mockMvc.perform(MockMvcRequestBuilders.get("/")) 
				// Permite obter informações sobre o objeto retornado pela requisição
				.andExpect(MockMvcResultMatchers.model().attributeExists("produtos")) 
				.andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/VIEWS/home.jsp")); // verifica o resultado
	}

	@Test // Teste de autenticação
	public void somenteAdminDeveAcessarProdutosForm() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/produtos/form").with(SecurityMockMvcRequestPostProcessors
				.user("user@casadocodigo.com.br").password("123456").roles("USUARIO")))
				.andExpect(MockMvcResultMatchers.status().is(403)); // testa se o status é 403 = Acesso negado
	}
}
