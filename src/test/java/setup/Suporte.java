package setup;

import static org.testng.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.function.Function;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;

public class Suporte {
	
	public void anexaDescricao(String message){
		System.out.println(message);
		Allure.addAttachment(message, "");
	}
	
	public void anexaEvidencia(String casoDeTeste) {
		Allure.addDescription(casoDeTeste);
		Allure.addAttachment(casoDeTeste,
				new ByteArrayInputStream(((TakesScreenshot) Capabilities.getDriver()).getScreenshotAs(OutputType.BYTES)));
	}
	
	protected WebElement aguardaElemento(ExpectedCondition<WebElement> expect) {
		return Capabilities.getWait().until(ExpectedConditions.refreshed(expect));
	}
	
	protected void aguardaElemento(Function<WebDriver, ?> expect) {
		Capabilities.getWait().until(ExpectedConditions.refreshed((ExpectedCondition<?>) expect));
	}
	
	
	/**
	 * Click no elemento
	 * 
	 * @param elemento
	 */
	protected void click(MobileElement elemento) {
		anexaDescricao("Clicando no elemento: " + elemento);
		aguardaElemento(ExpectedConditions.elementToBeClickable(elemento)).click();
	}
	
	/**
	 * Click no elemento
	 * 
	 * @param elemento
	 */
	protected void limparCampo(MobileElement elemento) {
		anexaDescricao("Limpando no elemento: " + elemento);
		aguardaElemento(ExpectedConditions.elementToBeClickable(elemento)).clear();
	}

	/**
	 * Preenche campo
	 * 
	 * @param elemento
	 * @param valor
	 */
	protected void preencheCampo(MobileElement elemento, String valor) {
		anexaDescricao("Preenchendo o elemento: " + elemento + " Com o valor: ".concat(valor));
		aguardaElemento(ExpectedConditions.elementToBeClickable(elemento)).sendKeys(valor);
	}
	
	
	/**
	 * Verificacao geral
	 * 
	 */
	protected void verificacao(MobileElement elemento, String check) {
		aguardaElemento(ExpectedConditions.visibilityOf(elemento));
		anexaDescricao("VALIDACAO -> ".concat(elemento.getText()).concat(" Igual a ").concat(check));
		assertTrue(elemento.getText().equalsIgnoreCase(check));
	}
}