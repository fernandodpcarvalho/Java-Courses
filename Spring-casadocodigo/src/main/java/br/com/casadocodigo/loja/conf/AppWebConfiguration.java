package br.com.casadocodigo.loja.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.cache.CacheBuilder;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.controllers.JsonViewResolver;
import br.com.casadocodigo.loja.dao.ProdutoDao;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.CarrinhoCompras;

@EnableWebMvc // habilita o uso do MVC do Spring
// @ComponentScan(basePackage={"br.com.casadocodigo.loja.controllers"})
// Spring MVC identifica o pacote das classes para saber onde procurar as
// classes Controllers
@ComponentScan(basePackageClasses = { HomeController.class, ProdutoDao.class, FileSaver.class, CarrinhoCompras.class })
@EnableCaching
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/VIEWS/");
		resolver.setSuffix(".jsp");
		// resolver.setExposeContextBeansAsAttributes(true);
		resolver.setExposedContextBeanNames("carrinhoCompras");
		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		// messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);

		return messageSource;
	}

	@Bean
	public FormattingConversionService mvcConversionService() {
		DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
		DateFormatterRegistrar registrar = new DateFormatterRegistrar();
		registrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
		registrar.registerFormatters(conversionService);
		return conversionService;
	}

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	/*
	 * @Bean public CacheManager cacheManager(){ return new
	 * ConcurrentMapCacheManager(); }
	 */

	@Bean
	public CacheManager cacheManager() {

		CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(20,
				TimeUnit.SECONDS);
		// expireAfterAccess(5,TimeUnit.MINUTES);

		GuavaCacheManager manager = new GuavaCacheManager();
		manager.setCacheBuilder(builder);

		return manager;
	}

	@Bean
	public ViewResolver contentNegociationViewResolver(ContentNegotiationManager manager) {
		List<ViewResolver> viewResolvers = new ArrayList<>();
		viewResolvers.add(internalResourceViewResolver());
		viewResolvers.add(new JsonViewResolver());
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(viewResolvers);
	    resolver.setContentNegotiationManager(manager);
		return resolver;
	};
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LocaleChangeInterceptor());
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		return new CookieLocaleResolver();
		
	}
	
/*	
	@Bean
    public MailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setUsername("fernandodpcarvalho@gmail.com");
        mailSender.setPassword("frnd84$&");

        Properties mailProperties = new Properties();

        mailProperties.put("mail.smtp.host", "smtp.gmail.com");  
        mailProperties.put("mail.smtp.auth", "true");  
        mailProperties.put("mail.smtp.port", "465");  
        mailProperties.put("mail.smtp.starttls.enable", "true");  
        mailProperties.put("mail.smtp.socketFactory.port", "465");  
        mailProperties.put("mail.smtp.socketFactory.fallback", "false");  
        mailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        mailSender.setJavaMailProperties(mailProperties);
        return mailSender;
    }
	
*/	
	
	@Bean
	public MailSender mailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setUsername("fernandodpcarvalho@gmail.com");
		mailSender.setPassword("");
		mailSender.setPort(587);
		
		Properties mailProperties = new Properties();
	    mailProperties.put("mail.smtp.auth", true);
	    mailProperties.put("mail.smpt.starttls.enable", true);

	    mailSender.setJavaMailProperties(mailProperties);
	    return mailSender;
	}

}
