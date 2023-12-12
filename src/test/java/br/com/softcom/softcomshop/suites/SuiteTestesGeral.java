package br.com.softcom.softcomshop.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.com.softcom.softcomshop.core.CoreTest;
import br.com.softcom.softcomshop.tests.TestCliente;
import br.com.softcom.softcomshop.tests.TestLogin;


@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	TestLogin.class,
	TestCliente.class,
})

public class SuiteTestesGeral extends CoreTest{
	
}