package br.com.softcom.softcomshop.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import br.com.softcom.softcomshop.core.CorePage;

public class PageMenu extends CorePage {

	@FindBy(linkText = "Vendas e NF-e")
	private WebElement linkVendasNFe;
	
	@FindBy(linkText = "Compras e Estoque")
	private WebElement linkComprasEstoque;
	
	@FindBy(linkText = "Configurações")
	private WebElement linkConfiguracoes;

	@FindBy(linkText = "Fornecedor")
	private WebElement linkFornecedor;

	@FindBy(id = "fornecedor")
	private WebElement fornecedor;

	@FindBy(linkText = "Produtos")
	private WebElement linkProdutos;

	@FindBy(linkText = "Atributos")
	private WebElement linkAtributos;

	@FindBy(id = "produto")
	private WebElement produto;

	@FindBy(id = "gestor_de_promoções")
	private WebElement gestorPromocoes;

	@FindBy(linkText = "Financeiro")
	private WebElement linkFinanceiro;

	@FindBy(id = "contas_a_receber")
	private WebElement contasaReceber;

	@FindBy(id = "contas_a_pagar")
	private WebElement contasaPagar;

	@FindBy(id = "clientes")
	private WebElement clientes;

	@FindBy(id = "funcionários")
	private WebElement funcionarios;

	@FindBy(id = "empresa")
	private WebElement linkEmpresa;

	@FindBy(id = "cartões")
	private WebElement linkCartoes;
	
	@FindBy(xpath = "//*[@id=\"menu\"]//*[@id=\"vendas\"]")
	private WebElement vendas;

	public PageClienteListagem abrirClientes() throws MalformedURLException {

		clicarLink(this.linkVendasNFe);
		waitDriver(this.clientes, 30);
		clicarLink(this.clientes);
		return PageFactory.initElements(getDriver(), PageClienteListagem.class);
	}

	public PageMenu getPageMenu() throws MalformedURLException {
		return PageFactory.initElements(getDriver(), PageMenu.class);
	}

}
