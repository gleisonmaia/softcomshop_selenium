package br.com.softcom.softcomshop.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.softcom.softcomshop.core.CorePage;

public class PageLogin extends CorePage {

	@FindBy(id = "login-email")
	private WebElement email;

	@FindBy(id = "login-senha")
	private WebElement senha;
	
	@FindBy(id = "login-acessar")
	private WebElement botaoAcessar;
	
	@FindBy(xpath = "//*[@id=\"login-erro\"]/strong")
	private WebElement alertaFalha;

	public void setEmail(String email) throws MalformedURLException {
		escrever(this.email, email);
	}

	public void setSenha(String senha) throws MalformedURLException {
		escrever(this.senha, senha);
	}

	public String getAlertaFalha() throws MalformedURLException {
		waitDriver(alertaFalha, 30);
		return this.alertaFalha.getText();
	}
	
	public PageLogin getPageLogin() throws MalformedURLException {
		return PageFactory.initElements(getDriver(), PageLogin.class);
	}
	
	public PageLogin submit() throws MalformedURLException {
		clicarBotao(this.botaoAcessar);
		return getPageLogin();
	}
	
	public PageHome submitUnicaEmpresa() throws InterruptedException, MalformedURLException {
		clicarBotao(this.botaoAcessar);
		Thread.sleep (1000);
		return PageFactory.initElements(getDriver(), PageHome.class);
	}
	
	public PageSelecionarEmpresa submitMultiEmpresa() throws InterruptedException, MalformedURLException {
		clicarBotao(this.botaoAcessar);
		Thread.sleep (1000);
		return PageFactory.initElements(getDriver(), PageSelecionarEmpresa.class);
	}

}
