package br.com.softcom.softcomshop.core;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


//Classe que conter� os métodos que irão interagir com os objetos das telas (Pages).
public class CorePage extends CoreDriver{
	
	//######################## INICIO TOAST MENSAGE ########################### 
	@FindBy(xpath = "//div[@class='toast-title']")
	public WebElement toastTituloMensagem;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	public WebElement toastMensagem;
	
	@FindBy(xpath = "/html/body/div[6]/h2")
	public WebElement modalMensagemTitulo;
	
	@FindBy(xpath = "/html/body/div[6]/p")
	public WebElement modalMensagemCorpo;
	
	@FindBy(xpath = "/html/body/div[6]/div[7]/div/button")
	public WebElement ModalBotaoOk;

	@FindBy(xpath = "/html/body/div[6]/div[7]/button")
	public WebElement ModalBotaoCancelar;
	
	public String getToastTituloMensagem() {
		return toastTituloMensagem.getText();
	}
	
	public String getToastMensagem() {
		return toastMensagem.getText();
	}
	
	public String getModalMensagemCorpo() {
		return modalMensagemCorpo.getText();
	}	
	
	//######################## FIM TOAST MENSAGE ################################
	

	public void escrever(WebElement e, String texto) throws MalformedURLException {
       waitDriverVisibility(e, 30);
       waitDriverClicavel(e, 30);
       e.clear();
       e.sendKeys(texto);
	}
	
	public void selecionarCombo(WebElement e, String valor) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		Select combo = new Select(e);
		combo.selectByVisibleText(valor);
	}

	public void limparCampo(WebElement e) {
		e.clear();
	}

	/* FIM Operações com TextField */

	/* Operações com botões */
	public void clicarBotao(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		e.click();
	}
	
	public void clicarBotaoForcado(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", e);
	}


	public void submitBotao(WebElement e) {
		e.submit();
	}

	/* FIM Operações com botões */

	/* Operações com textos */

	public String obterTexto(By element) throws MalformedURLException {
		return getDriver().findElement(element).getText();
	}

	public String obterTexto(String xPath) throws MalformedURLException {
		return obterTexto(By.xpath(xPath));
	}

	/* FIM Operações com textos */

	/* Opera��es com link */

	public void clicarLink(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		e.click();
	}

//	/* FIM Operações com link */
//
//	/* Opera��es com combo */
//
//	public void selecionarComboAutoCompleteElemento(By elemento) {
//

	public void selecionarComboAutoCompleteSemPlus(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		Actions actions = new Actions(getDriver());
		actions.moveToElement(e);
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();

	}
	
	public void selecionarComboAutoCompleteComPlus(WebElement e) throws MalformedURLException {
		waitDriverVisibility(e, 30);
		waitDriverClicavel(e, 30);
		Actions actions = new Actions(getDriver());
		actions.moveToElement(e);
		// actions.click();
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(Keys.TAB);
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();

	}

//	/* FIM Operações com combo */

//	/* Operações Arrastar e Soltar (Drag and Drop) */
//
	public void arrastarSoltar(String source, String target) throws MalformedURLException {

		WebElement origem = getDriver().findElement(By.xpath(source));
		WebElement destino = getDriver().findElement(By.xpath(target));

		Actions actions = new Actions(getDriver());
		actions.dragAndDrop(origem, destino).build().perform();
	}

	/* FIM Operações Arrastar e Soltar (Drag and Drop) */
	
	public void selecionarCheckBox(WebElement element) {
		element.click();
		
	}

}
