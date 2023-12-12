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
import br.com.softcom.softcomshop.pages.PageHome;

public class TestHome extends CoreTest {
	
	private PageHome pageHome;
	
	@BeforeEach
	public void setup() throws Exception {
		this.pageHome = PageFactory.initElements(getDriver(), PageHome.class);
	}

	@AfterEach
	public void tearDown() throws Exception {
		this.pageHome = null;
	}

	@Test
	@DisplayName("Teste botão Informativos")
	@Tags({ @Tag("home"), @Tag("001") })
	public void abrirCadastroClientes() throws MalformedURLException {
//		PageHome home = this.pageHome.getPageHome();
//		PageHome pagina = home.botaoInformativo();
//		assertEquals("Sem novidades.", pagina.getInformativo());
	}

}
