package br.com.softcom.softcomshop.stub;

import br.com.softcom.softcomshop.model.ModelLogin;

public class StubLogin implements ModelLogin {

	@Override
	public String getEmail() {
		return "testeautomatico@gmail.com";
	}

	@Override
	public String getSenhaValida() {
		return "123";
	}

	@Override
	public String getSenhaInvalida() {
		return "123q";
	}
}
