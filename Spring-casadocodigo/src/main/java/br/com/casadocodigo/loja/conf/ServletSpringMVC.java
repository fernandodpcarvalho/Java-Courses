package br.com.casadocodigo.loja.conf;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	//Aqui a configuração sobe ao inicializar o sistema
	@Override
	protected Class<?>[] getRootConfigClasses() { 
		return new Class[]{SecurityConfiguration.class, 
				AppWebConfiguration.class, JPAConfiguration.class,
				JPAProductionConfiguration.class};
	}
	
	//Aqui a configuração sobe ao ser chamada
	@Override
	protected Class<?>[] getServletConfigClasses() { //Retorna um array com as classes de configurações
		return new Class[]{}; 
	}

	@Override
	protected String[] getServletMappings() { //Retorna um array com os mapeamentos que a Servlet deve atender
		return new String[] {"/"}; //servlet do SpringMVC atenderá as requisições a partir da raiz do projeto (/)
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(""));
		super.customizeRegistration(registration);
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		//characterEncodingFilter.setEncoding("UTF-8");

		return new Filter[] {characterEncodingFilter, new OpenEntityManagerInViewFilter()};
		//return new Filter[] {characterEncodingFilter};
	}
/*
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	    super.onStartup(servletContext);
	    servletContext.addListener(new RequestContextListener());
	    servletContext.setInitParameter("spring.profiles.active", "dev");
	}
	*/
}
