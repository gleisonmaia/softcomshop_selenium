package br.com.softcom.softcomshop.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.softcom.softcomshop.core.CorePage;

public class PageSelecionarEmpresa extends CorePage {
	
	@FindBy(xpath = "//*[@id=\"login-empresa-1\"]/div[2]/h3")
	private WebElement empresa;
	
	@FindBy(xpath = "//*[@id=\"login-empresa-1\"]/div[2]/h4")
	private WebElement usuario;
	
	@FindBy(xpath = "//*[@id=\"login-empresa-1\"]/div[2]/h5")
	private WebElement email;
	
	@FindBy(id = "login-empresa-1")
	private WebElement botaoAcessar;

	public String getEmpresa() {
		return this.empresa.getText();
	}

	public String getUsuario() {
		return this.usuario.getText();
	}
	
	public String getEmail() {
		return this.email.getText();
	}

	public PageSelecionarEmpresa getPageSelecionarEmpresa() throws MalformedURLException {
		return PageFactory.initElements(getDriver(), PageSelecionarEmpresa.class);
	}
	
	public PageHome submit() throws MalformedURLException {
		clicarLink(this.botaoAcessar);
		return PageFactory.initElements(getDriver(), PageHome.class);
	}

}
