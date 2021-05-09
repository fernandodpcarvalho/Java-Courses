package br.com.caelum.teste;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizado {

    public static void main(String[] args) {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Fernando\\workspace\\TesteSelenium\\lib\\chromedriver.exe");
        // abre firefox
    	 
        WebDriver driver = new ChromeDriver();

        // acessa o site do google
        driver.get("http://www.google.com.br/");

        // digita no campo com nome "q" do google
        WebElement campoDeTexto = driver.findElement(By.name("q"));
        campoDeTexto.sendKeys("Caelum");

        // submete o form
        campoDeTexto.submit();

    }
}
