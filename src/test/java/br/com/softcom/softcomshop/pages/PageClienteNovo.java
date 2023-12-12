package br.com.softcom.softcomshop.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import br.com.softcom.softcomshop.core.CorePage;
import br.com.softcom.softcomshop.core.Constantes.Pessoa;
import br.com.softcom.softcomshop.model.ModelCliente;
import br.com.softcom.softcomshop.stub.StubCliente;


public class PageClienteNovo extends CorePage {
	
	private ModelCliente ModelCliente = new StubCliente();

	@FindBy(xpath = "//*[@id=\"tabs-cliente\"]/ul/li[2]/a")
	private WebElement abaOutrosEnderecos;

	@FindBy(linkText ="Contatos")
	private WebElement abaContatos;

	@FindBy(id = "pessoa")
	private WebElement pessoa;

	@FindBy(id = "form-pessoa-juridica")
	private WebElement formClienteJuridica;

	@FindBy(id = "form-pessoa-fisica")
	private WebElement formClienteFisica;

	@FindBy(id = "cpf_cnpj")
	private WebElement cpfCnpj;

	@FindBy(id = "inscricao_estadual")
	private WebElement inscricaoEstadual;

	@FindBy(id = "contribuinte_icms")
	private WebElement contribuinteIcms;

	@FindBy(id = "razao_social")
	private WebElement razaoSocial;

	@FindBy(id = "rg")
	private WebElement rg;

	@FindBy(id = "nome")
	private WebElement nome;

	@FindBy(id = "cep")
	private WebElement cep;

	@FindBy(id = "busca-cep_cep")
	private WebElement botaoBuscaCep;

	@FindBy(id = "endereco")
	private WebElement endereco;

	@FindBy(id = "numero")
	private WebElement numero;

	@FindBy(id = "complemento")
	private WebElement complemento;

	@FindBy(id = "auto_bairro")
	private WebElement bairro;
	
	@FindBy(xpath = "//*[@id=\"div_auto_bairro\"]/div/div[2]/ul/li[1]/a")
	private WebElement bairroListagem;
	
	@FindBy(xpath = "//*[@id=\"form-modal-bairro\"]//*[@id=\"nome\"]")
	private WebElement bairroDescricao;
	
	@FindBy(xpath = "//*[@id=\"form-modal-bairro\"]//*[@id=\"taxa_entrega\"]")
	private WebElement bairroTaxaEntrega;
	
	@FindBy(xpath = "//*[@id=\"form-modal-bairro\"]//*[@id=\"btn-salvar\"]")
	private WebElement botaoSalvarBairro;
	
	@FindBy(id = "auto_cidade_id")
	private WebElement cidade;

	@FindBy(xpath = "//*[@id=\"div_auto_cidade_id\"]/div/div[2]/ul/li[1]/a")
	private WebElement cidadeListagem;

	@FindBy(id = "observacao")
	private WebElement observacao;

	@FindBy(id = "btn-salvar")
	private WebElement botaoSalvar;

	@FindBy(id = "btn-excluir")
	private WebElement botaoExcluir;

	@FindBy(xpath = "//button[@class='confirm' and text()='Sim, pode excluir!']")
	private WebElement botaoConfirmarExcluir;

	@FindBy(id = "auto_tipo_cliente_id")
	private WebElement tipocliente;
	
	@FindBy(xpath = "//*[@id=\"div_nome\"]/span")
	private WebElement mensagemObrigatorio;
	
	public PageMenu getMenu() throws MalformedURLException{
		return PageFactory.initElements(getDriver(), PageMenu.class);
	}

	public PageClienteNovo getPageClienteNovo() throws MalformedURLException {
		return PageFactory.initElements(getDriver(), PageClienteNovo.class);
	}

	public PageLogin getPageLogin() throws MalformedURLException {
		return PageFactory.initElements(getDriver(), PageLogin.class);
	}

	public String getPessoa() {
		return pessoa.getText();
	}

	public void setPessoa(Pessoa tipopessoa) throws MalformedURLException {
		waitDriverClicavel(this.pessoa, 30);
		selecionarCombo(this.pessoa, tipopessoa.toString());
		waitDriver(formClienteFisica, 90);
	}

	public String getCpfCnpj() {
		return cpfCnpj.getText();
	}

	public void setCpfCnpj(String cpfcnpj) throws InterruptedException, MalformedURLException {
		Thread.sleep (1000);
		escrever(this.cpfCnpj, cpfcnpj);
	}
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual.getText();
	}
	
	public void setInscricaoEstadual(String inscricaoEstadual) throws MalformedURLException {
		escrever(this.inscricaoEstadual, inscricaoEstadual);
	}
	
	public String getContribuinteIcms() {
		return contribuinteIcms.getText();
	}

	public void setContribuinteIcms(String contribuinteIcms) throws MalformedURLException {
		selecionarCombo(this.contribuinteIcms, contribuinteIcms);
	}

	public String getNome() {
		return nome.getText();
	}

	public void setNome(String nome) throws MalformedURLException {
		escrever(this.nome, nome);
	}
	
	public String getRazaoSocial() {
		return razaoSocial.getText();
	}
	
	public void setRazaoSocial(String nome) throws MalformedURLException {
		escrever(this.razaoSocial, nome);
	}

	public String getCep() {
		return cpfCnpj.getText();
	}

	public void setCep(String cep) throws MalformedURLException {
		escrever(this.cep, cep);
	}

	public String getEndereco() {
		return endereco.getText();
	}

	public void setEndereco(String endereco) throws MalformedURLException {
		escrever(this.endereco, endereco);
	}

	public String getNumero() {
		return numero.getText();
	}

	public void setNumero(String numero) throws MalformedURLException {
		escrever(this.numero, numero);
	}

	public String getBairro() {
		return bairro.getText();
	}

	public void setBairro(String bairro,String TaxaEntrega) throws MalformedURLException {
		escrever(this.bairro, bairro);
		waitDriverVisibility(this.bairroListagem, 10);
		selecionarComboAutoCompleteSemPlus(this.bairro);
		//escrever(this.bairroDescricao, bairro);
		escrever(this.bairroTaxaEntrega, TaxaEntrega);
		//clicarBotao(this.bairroDescricao);
		clicarBotao(this.botaoSalvarBairro);
	}

	public String getCidade() {
		return cidade.getText();
	}

	public void setCidade(String cidade) throws MalformedURLException {
		escrever(this.cidade, cidade);
		waitDriver(this.cidadeListagem, 30);
		selecionarComboAutoCompleteSemPlus(this.cidade);
	}

	public String getComplemento() {
		return complemento.getText();
	}

	public void setComplemento(String complemento) throws MalformedURLException {
		escrever(this.complemento, complemento);
	}

	public String getObservacao() {
		return observacao.getText();
	}

	public void setObservacao(String observacao) throws MalformedURLException {
		escrever(this.observacao, observacao);
	}

	public PageClienteNovo submit() throws MalformedURLException {
		clicarBotao(this.botaoSalvar);
		return getPageClienteNovo();
	}

	public PageClienteNovo excluir() throws MalformedURLException, InterruptedException {
		Thread.sleep (1000);
		clicarBotao(this.botaoExcluir);
		Thread.sleep (2000);
		waitDriverVisibility(this.botaoConfirmarExcluir, 10);
		clicarBotao(this.botaoConfirmarExcluir);
		waitDriverVisibility(this.toastTituloMensagem, 50);
		return getPageClienteNovo();
	}

	public void setRG(String rg) throws MalformedURLException {
		escrever(this.rg, rg);
	}

	public void setTipoCliente(String tipocliente) throws MalformedURLException {
		escrever(this.tipocliente, tipocliente);
	}
	
	public String getMensagemObrigatorio() {
		return mensagemObrigatorio.getText();
	}
	
	public PageClienteNovo pesquisarCliente(String nomeCliente) throws MalformedURLException {

		PageClienteListagem clienteListagem2 = getMenu().abrirClientes();
		clienteListagem2.abrirPesquisa();
		clienteListagem2.setAtributoDescricaoPesquisa(nomeCliente);
		PageClienteListagem clienteListagemPesquisado = clienteListagem2.pesquisarSubmit();

		return clienteListagemPesquisado.editarPrimeiroCadastro();
	}
	
	
	public PageClienteNovo cadastrarClienteCamposObrigatorios(String nomeCliente) throws MalformedURLException {
		PageClienteListagem clienteListagem = getMenu().abrirClientes();
		PageClienteNovo clienteNovo = clienteListagem.novoCadastro();

		clienteNovo.setNome(nomeCliente);
		clienteNovo.setInscricaoEstadual(ModelCliente.getIE());
		clienteNovo.submit();

		return pesquisarCliente(nomeCliente);
	}
	
	public PageClienteNovo cadastrarClienteCompleto(String nomeCliente,Pessoa tipoPessoa) throws MalformedURLException, InterruptedException {

		PageClienteListagem clienteListagem = getMenu().abrirClientes();
		PageClienteNovo clienteNovo = clienteListagem.novoCadastro();

		clienteNovo.setPessoa(tipoPessoa);
		
		if(tipoPessoa.toString()=="JURIDICA") {
        	clienteNovo.setCpfCnpj(ModelCliente.getCnpj());
        	clienteNovo.setRazaoSocial(nomeCliente);
        	clienteNovo.setInscricaoEstadual(ModelCliente.getIE());
		}else {
        	clienteNovo.setCpfCnpj(ModelCliente.getCpf());
        	clienteNovo.setRG(ModelCliente.getRG());
	    }
		
		clienteNovo.setContribuinteIcms(ModelCliente.getContribuinte());
		clienteNovo.setNome(nomeCliente);
		clienteNovo.setCep(ModelCliente.getCep());
		clienteNovo.setEndereco(ModelCliente.getEndereco());
		clienteNovo.setNumero(ModelCliente.getNumero());
		clienteNovo.setBairro(ModelCliente.getBairro(),"19.99");
		clienteNovo.setCidade(ModelCliente.getCidade());
		clienteNovo.setComplemento(ModelCliente.getComplemento());
		clienteNovo.setObservacao(ModelCliente.getObservacao());
		return clienteNovo.submit();
	}
}