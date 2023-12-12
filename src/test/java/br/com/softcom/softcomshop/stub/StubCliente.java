package br.com.softcom.softcomshop.stub;

import br.com.softcom.softcomshop.model.ModelCliente;
import br.com.softcom.softcomshop.uteis.UtilAleatorio;
import br.com.softcom.softcomshop.uteis.UtilCGC;

public class StubCliente implements ModelCliente {
	UtilAleatorio ale = new UtilAleatorio();
	UtilCGC cgc = new UtilCGC();
	
	
	@Override
	public String getPessoa() {
		return "FISICA";
	}
	
	@Override
	public String getCpf() {
		//return "07553848492"
		return cgc.cpf(false);
	}
	
	@Override
	public String getCnpj() {
		//return "07553848492"
		return cgc.cnpj(false);
	}
	
	@Override
	public String getIE() {
		return "594186528";
	}

	@Override
	public String getRG() {
		//return "1122233";
		return cgc.rg(false);
	}

	@Override
	public String getContribuinte() {
		return "Não Contribuinte";
	}
	
	@Override
	public String getNome() {
		//return "Teste";
		//return ale.gerarNome();
		return ale.gerarNomeAssinado();
	}

	@Override
	public String getCep() {
		
		return "58030021";
		//return ale.gerarString(8, 1);
	}

	@Override
	public String getEndereco() {
		//return "AVENIDA RIO GRANDE DO SUL";
		return ale.gerarString(10) + " " + ale.gerarString(5); 
	}
	
	@Override
	public String getNumero() {
		//return "1520";
		return ale.gerarString(3, 1);
	}
	
	@Override
	public String getComplemento() {
		//return "Por Tras do banco Itau na Epitacio";
		return ale.gerarString(50);
		
	}

	@Override
	public String getBairro() {
		//return "Estados";
		return ale.gerarString(10); 
	}
	
	@Override
	public String getCidade() {
		return "JOAO PESSOA - PB";
	}

	@Override
	public String getObservacao() {
		return "Cadastro realizado de forma automática a nível de testes";
	}
	

	@Override
	public String getTipoCliente() {
		return "CONSUMIDOR";
	}
}