package br.com.softcom.softcomshop.tests;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;

import br.com.softcom.softcomshop.core.CoreTest;
import br.com.softcom.softcomshop.model.ModelLogin;
import br.com.softcom.softcomshop.pages.PageHome;
import br.com.softcom.softcomshop.pages.PageLogin;
import br.com.softcom.softcomshop.pages.PageSelecionarEmpresa;
import br.com.softcom.softcomshop.stub.StubLogin;
import br.com.softcom.softcomshop.uteis.Propriedades;

//@Execution(ExecutionMode.CONCURRENT)
public class TestLogin extends CoreTest {

	Propriedades propriedades = new Propriedades();
	private PageLogin pagelogin;
	private ModelLogin modelLogin = new StubLogin();

	@BeforeEach
	public void setupCoreTest() throws Exception {
		getDriver().get(Propriedades.url_sistema);
		getDriver().manage().window().maximize();
		this.pagelogin = PageFactory.initElements(getDriver(), PageLogin.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.pagelogin = null;
	}

	@Test
	@DisplayName("Testar o login válido Unica Empresa")
	@Tags({ @Tag("login"), @Tag("login002"), @Tag("Automatico") })
	public void loginValido() throws InterruptedException, MalformedURLException {
		try {
			PageLogin login = this.pagelogin.getPageLogin();
			login.setEmail(this.modelLogin.getEmail());
			login.setSenha(this.modelLogin.getSenhaValida());

			if (Propriedades.multi_empresa) {
				PageSelecionarEmpresa pse = login.submitMultiEmpresa();
				PageHome pagina = pse.submit();
				assertTrue(pagina.getFone0800().contains("0800 003 3600"));
			} else {
				PageHome pagina = login.submitUnicaEmpresa();
				assertTrue(pagina.getFone0800().contains("0800 003 3600"));
			}
		} finally {
			killDriver();
		}
	}

	@Test
	@DisplayName("Testar o login Inválido")
	@Tags({ @Tag("login"), @Tag("login001"), @Tag("Automatico") })
	public void loginInvalido() throws InterruptedException, MalformedURLException {
		try {
			PageLogin login = this.pagelogin.getPageLogin();
			login.setEmail(this.modelLogin.getEmail());
			login.setSenha(this.modelLogin.getSenhaInvalida());
			PageLogin pagina = login.submit();
			assertTrue(pagina.getAlertaFalha().contains("algo errado"));
//			Assert.assertEquals("Há algo errado!", pagina.getAlertaFalha());
		} finally {
			killDriver();
		}
	}

}
