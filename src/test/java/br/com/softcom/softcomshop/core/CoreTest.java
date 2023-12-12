package br.com.softcom.softcomshop.core;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.PageFactory;
import br.com.softcom.softcomshop.model.ModelLogin;
import br.com.softcom.softcomshop.pages.PageLogin;
import br.com.softcom.softcomshop.pages.PageSelecionarEmpresa;
import br.com.softcom.softcomshop.stub.StubLogin;
import br.com.softcom.softcomshop.uteis.Propriedades;

//Classe que conterá os métodos que serão utilizados por todas as classes de teste.
public class CoreTest extends CorePage {

	Propriedades propriedades = new Propriedades();
	
	private ModelLogin modelLogin = new StubLogin();
	
	@BeforeEach
	public void setupCoreTest() throws Exception {
		getDriver().get(Propriedades.url_sistema);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logar();
	}
	
	@AfterEach
	public void tearDownCoreTest() {
		if (Propriedades.fechar_browser) {
			killDriver();
		}
	}
	
	public void logar() throws InterruptedException, MalformedURLException {
		PageLogin login = PageFactory.initElements(getDriver(), PageLogin.class);
		login.setEmail(modelLogin.getEmail());
		login.setSenha(modelLogin.getSenhaValida());
		
		if (Propriedades.multi_empresa) {
			PageSelecionarEmpresa pagina = login.submitMultiEmpresa();
			pagina.submit();
		} else {
			login.submitUnicaEmpresa();
		}
	}
	
}
