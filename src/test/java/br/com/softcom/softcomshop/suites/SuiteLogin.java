package br.com.softcom.softcomshop.suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Suite de testes para os clientes do tipo A")
@SelectPackages({"br.com.softcom.softcomshop.tests"})
public class SuiteLogin {

}