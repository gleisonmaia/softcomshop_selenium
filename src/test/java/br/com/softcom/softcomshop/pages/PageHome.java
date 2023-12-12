package br.com.softcom.softcomshop.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.softcom.softcomshop.core.CorePage;

public class PageHome extends CorePage {
	
	@FindBy(xpath = "//*[@id=\"topo-notificacoes\"]/nav/ul/div/a/span/span/span")
	private WebElement empresa;
	
	@FindBy(xpath = "//*[@id=\"topo-notificacoes\"]/nav/ul/div/a/span/span/strong")
	private WebElement usuario;
	
	@FindBy(xpath = "//*[@id=\"topo-notificacoes\"]/nav/ul/li[1]/span")
	private WebElement fone0800;
	
	@FindBy(xpath = "//*[@id=\"topo-notificacoes\"]/nav/div[2]/ol/li/a")
	private WebElement breadcrumbs;
	
	@FindBy(xpath = "//*[@id=\"topo-notificacoes\"]/nav/ul/li[3]/a")
	private WebElement botaoInformativo;
	
	@FindBy(xpath = "//*[@id=\"topo-notificacoes\"]/nav/ul/li[3]/ul/li/div/div/strong")
	private WebElement informativo;
	
	@FindBy(xpath = "//*[@id=\"topo-notificacoes\"]/nav/div[1]/a")
	private WebElement botaoMenu;

	public String getEmpresa() {
		return this.empresa.getText();
	}

	public String getUsuario() {
		return this.usuario.getText();
	}
	
	public String getFone0800() {
		return this.fone0800.getText();
	}
	
	public String getBreadcrumbs() {
		return this.breadcrumbs.getText();
	}
	
	public String getInformativo() {
		return this.informativo.getText();
	}

	public PageHome getPageHome() throws MalformedURLException {
		return PageFactory.initElements(getDriver(), PageHome.class);
	}
	
	public PageHome botaoMenu() throws MalformedURLException {
		clicarBotao(this.botaoMenu);
		return getPageHome();
	}
	
	public PageHome botaoInformativo() throws MalformedURLException {
		clicarBotao(this.botaoInformativo);
		return getPageHome();
	}

}
