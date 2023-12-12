package br.com.softcom.softcomshop.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.softcom.softcomshop.core.CorePage;

public class PageClienteListagem extends CorePage {

	@FindBy(id = "btn-novo")
	private WebElement novoCadastro;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/a")
	private WebElement editarCadastro;

	@FindBy(id = "btn-pesquisa")
	private WebElement pesquisaCadastro;

	@FindBy(id = "btn-excluir-selecionados")
	private WebElement excluirCadastro;

	@FindBy(xpath = "//*[@id=\"5db490b5d6928\"]/tbody/tr[1]/td[1]/div/input")
	private WebElement selecionarCadastro;

	// ######### Pesquisa ############
	@FindBy(id = "btn-pesquisa")
	private WebElement abrirPesquisa;

	@FindBy(id = "nome")
	private WebElement descricaoPesquisa;

	@FindBy(id = "btn-pesquisar")
	private WebElement pesquisarSubmit;
	// ##############################

	public PageClienteListagem getPageClienteListagem() throws MalformedURLException {
		return PageFactory.initElements(getDriver(), PageClienteListagem.class);
	}

	public PageClienteNovo novoCadastro() throws MalformedURLException {
		clicarBotao(this.novoCadastro);
		return PageFactory.initElements(getDriver(), PageClienteNovo.class);
	}

	public PageClienteNovo editarCadastro(String codigo) throws MalformedURLException {
		WebElement editarCadastro = getDriver().findElement(By.xpath("//a[@href ='cliente/" + codigo + "/editar']"));
		clicarBotao(editarCadastro);
		return PageFactory.initElements(getDriver(), PageClienteNovo.class);
	}

	public PageClienteNovo pesquisaCadastro() throws MalformedURLException {
		clicarBotao(this.pesquisaCadastro);
		return PageFactory.initElements(getDriver(), PageClienteNovo.class);
	}

	public PageAlert excluirCadastro() throws MalformedURLException {
		clicarBotao(this.excluirCadastro);
		return PageFactory.initElements(getDriver(), PageAlert.class);
	}

	public PageClienteNovo selecionarCadastro() throws MalformedURLException {
		clicarBotao(this.selecionarCadastro);
		return PageFactory.initElements(getDriver(), PageClienteNovo.class);
	}

	// ######### Pesquisa ############
	public PageClienteListagem abrirPesquisa() throws MalformedURLException {
		clicarBotao(this.abrirPesquisa);
		return getPageClienteListagem();
	}

	public void setAtributoDescricaoPesquisa(String descricao) throws MalformedURLException {
		waitDriverClicavel(this.descricaoPesquisa, 30);
		escrever(this.descricaoPesquisa, descricao);
	}

	public PageClienteListagem pesquisarSubmit() throws MalformedURLException {
		clicarBotao(this.pesquisarSubmit);
		return getPageClienteListagem();
	}

	public PageClienteNovo editarPrimeiroCadastro() throws MalformedURLException {
		waitDriverClicavel(this.editarCadastro, 30);
		clicarBotao(this.editarCadastro);
		return PageFactory.initElements(getDriver(), PageClienteNovo.class);
	}
	// ######### Pesquisa FIM ############
}
