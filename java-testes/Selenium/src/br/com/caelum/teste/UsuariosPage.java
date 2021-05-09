package br.com.caelum.teste;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Representa a página de listagem de usuarios
public class UsuariosPage {

	private WebDriver driver;

	public UsuariosPage(WebDriver driver) {
		this.driver = driver;
	}

	public void visita() {
		driver.get("http://localhost:8080/usuarios");
	}

	public NovoUsuarioPage novo() {
		driver.findElement(By.linkText("Novo Usuário")).click();
		return new NovoUsuarioPage(driver);
	}
	
	public AlteraUsuarioPage alteraUsuarioNaPosiao(int posicao){
		driver.findElements(By.linkText("editar")).get(posicao - 1).click();
		return new AlteraUsuarioPage(driver);		
	}

	public void excluiUsuarioNaPosicao(int posicao) {
		driver.findElements(By.tagName("button")).get(posicao - 1).click();
		// pega o alert que está aberto
		Alert alert = driver.switchTo().alert();
		// confirma
		alert.accept();
	}

	public boolean existeNaListagem(String nome, String email) {
		return driver.getPageSource().contains(nome) && driver.getPageSource().contains(email);
	}
}
