package br.com.caelum.teste;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlteraUsuarioPage {

	private WebDriver driver;

	public AlteraUsuarioPage(WebDriver driver) {
		this.driver = driver;
	}

	public void altera(String novoNome, String novoEmail) {

		WebElement txtNome = driver.findElement(By.name("usuario.nome"));
		WebElement txtEmail = driver.findElement(By.name("usuario.email"));

		txtNome.clear();
		txtNome.sendKeys(novoNome);
		txtEmail.clear();
		txtEmail.sendKeys(novoEmail);
		
		txtNome.submit();
	}

}
