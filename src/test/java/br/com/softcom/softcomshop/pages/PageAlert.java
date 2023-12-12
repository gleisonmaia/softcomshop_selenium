package br.com.softcom.softcomshop.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.softcom.softcomshop.core.CorePage;

public class PageAlert extends CorePage {

	@FindBy(xpath = "//div[@class='toast-title']")
	private WebElement toastTituloMensagem;
	
	@FindBy(xpath = "//div[@class='toast-message']")
	private WebElement toastMensagem;
	
	@FindBy(xpath = "/html/body/div[6]/h2")
	private WebElement modalMensagemTitulo;
	
	@FindBy(xpath = "/html/body/div[6]/p")
	private WebElement modalMensagemCorpo;
	
	@FindBy(xpath = "/html/body/div[6]/div[7]/div/button")
	private WebElement ModalBotaoOk;

	@FindBy(xpath = "/html/body/div[6]/div[7]/button")
	private WebElement ModalBotaoCancelar;

	
	public PageAlert getPageAlert() throws MalformedURLException {
		return PageFactory.initElements(getDriver(), PageAlert.class);
	}
	
	public String getToastTituloMensagem() {
		return toastTituloMensagem.getText();
	}
	
	public String getToastMensagem() {
		return toastMensagem.getText();
	}
	
	public String getModalMensagemCorpo() {
		return modalMensagemCorpo.getText();
	}	
	
}
