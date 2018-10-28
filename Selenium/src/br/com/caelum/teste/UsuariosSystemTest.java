package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {

	WebDriver driver;
	private UsuariosPage usuarios;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Fernando\\workspace\\TesteSelenium\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/apenas-teste/limpa");
		usuarios = new UsuariosPage(driver);
	}

//	@Test
//	public void deveAdicionarUsuario() {
//		usuarios.visita();
//		usuarios.novo().cadastra("Fernando Carvalho", "fernando@gmail.com");
//		assertTrue(usuarios.existeNaListagem("Fernando Carvalho", "fernando@gmail.com"));
//	}
//
//	@Test
//	public void deveExcluirUsuario() {
//		// deveAdicionarUsuario();
//		usuarios.visita();
//		usuarios.excluiUsuarioNaPosicao(1);
//		assertFalse(usuarios.existeNaListagem("Fernando Carvalho", "fernando@gmail.com"));
//	}

	@Test
	public void deveAlterarUsuario() {
		usuarios.visita();
		usuarios.novo().cadastra("Fernando", "fernando@gmail.com");
		espera();
		assertTrue(usuarios.existeNaListagem("Fernando", "fernando@gmail.com"));
		
		usuarios.alteraUsuarioNaPosiao(1).altera("Fernando Carvalho", "fernandocarvalho@gmail.com");
		espera();
		assertTrue(usuarios.existeNaListagem("Fernando Carvalho", "fernandocarvalho@gmail.com"));	
		
	}
	
	private void espera(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void finaliza() {
		driver.close();
	}

}

// Para testar tentativa de cadastrar usuário sem nome:
// assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
