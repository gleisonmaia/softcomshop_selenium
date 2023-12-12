package br.com.softcom.softcomshop.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import br.com.softcom.softcomshop.core.CoreTest;
import br.com.softcom.softcomshop.core.Constantes.Pessoa;
import br.com.softcom.softcomshop.model.ModelCliente;
import br.com.softcom.softcomshop.pages.PageAlert;
import br.com.softcom.softcomshop.pages.PageClienteListagem;
import br.com.softcom.softcomshop.pages.PageClienteNovo;
import br.com.softcom.softcomshop.pages.PageMenu;
import br.com.softcom.softcomshop.stub.StubCliente;
import br.com.softcom.softcomshop.uteis.UtilCGC;

public class TestCliente extends CoreTest {

	private PageMenu pageMenu;
	private ModelCliente ModelCliente = new StubCliente();

	@BeforeEach
	public void setup() throws Exception {
		this.pageMenu = PageFactory.initElements(getDriver(), PageMenu.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.pageMenu = null;
	}

	@Test
	@DisplayName("Teste cadastrar novo Cliente")
	@Tags({ @Tag("cadastro"), @Tag("cliente"), @Tag("novo"), @Tag("Automatico") })
	public void testCadastrarClienteJuridico() throws MalformedURLException, InterruptedException {
		try {			
			String nomeCliente = ModelCliente.getNome();
			PageClienteNovo cli = new PageClienteNovo();
			PageClienteNovo pagina = cli.cadastrarClienteCamposObrigatorios(nomeCliente);
			//assertEquals("Sucesso", pagina.getToastTituloMensagem());
		} finally {
			killDriver();
		}
	}

	@Test
	@DisplayName("Teste Editar Cliente")
	@Tags({ @Tag("cadastro"), @Tag("cliente"), @Tag("editar"), @Tag("Automatico") })
	public void testEditarCliente() throws MalformedURLException {
		try {
			String nomeCliente = ModelCliente.getNome();
			PageClienteNovo cli = new PageClienteNovo();
			PageClienteNovo clienteNovo = cli.cadastrarClienteCamposObrigatorios(nomeCliente);
			clienteNovo.setNome(nomeCliente + " Editado");
			PageClienteNovo pagina = clienteNovo.submit();
			assertEquals("Sucesso", pagina.getToastTituloMensagem());
		} finally {
			killDriver();
		}

	}

	@Test
	@DisplayName("Teste Excluir Cliente")
	@Tags({ @Tag("cadastro"), @Tag("cliente"), @Tag("excluir"), @Tag("Automatico") })
	public void testExcluirCliente() throws MalformedURLException, InterruptedException {
		try {
			String nomeCliente = ModelCliente.getNome();
			PageClienteNovo cli = new PageClienteNovo();
			PageClienteNovo clienteNovo = cli.cadastrarClienteCamposObrigatorios(nomeCliente);
			PageClienteNovo pagina = clienteNovo.excluir();
			assertEquals("Sucesso", pagina.getToastTituloMensagem());
		} finally {
			killDriver();
		}

	}
	
}
