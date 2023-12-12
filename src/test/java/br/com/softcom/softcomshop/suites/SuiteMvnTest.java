package br.com.softcom.softcomshop.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;
import org.junit.platform.suite.api.SelectClasses;

import br.com.softcom.softcomshop.tests.TestCliente;
import br.com.softcom.softcomshop.tests.TestLogin;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Suite de testes")
//@SelectPackages({"br.com.softcom.softcomshop.tests"})
//@IncludeTags({
//	"Automatico"	
//	})
@SelectClasses({
	TestLogin.class,
	TestCliente.class,
})
public class SuiteMvnTest {

}