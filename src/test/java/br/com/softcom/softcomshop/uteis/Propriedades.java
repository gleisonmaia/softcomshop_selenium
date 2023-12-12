package br.com.softcom.softcomshop.uteis;

import java.io.InputStream;
import java.util.Properties;

public class Propriedades {
	
	//definindo a vari�vel que ter� a url do sistema a ser testado, obtida do arquivo propriedades.
	public static String servidor;
	public static String url_sistema;
	public static String browser;	
	public static boolean fechar_browser;
	public static boolean multi_empresa;
	public static boolean ocultar_browser;
	
	//definindo vari�vel com o nome do arquivo propriedades
	private static final String arquivo_propriedades = "propriedades";
	
	
	//lendo o arquivo propriedades e capturando as configura��es.
	static {
		Properties propriedades = lerArquivoPropriedades();
		servidor = propriedades.getProperty("servidor_grid");
		url_sistema = propriedades.getProperty("url_sistema");
		browser = propriedades.getProperty("browser");
		fechar_browser = Boolean.parseBoolean(propriedades.getProperty("fechar_browser"));
		multi_empresa = Boolean.parseBoolean(propriedades.getProperty("multi_empresa"));
		ocultar_browser = Boolean.parseBoolean(propriedades.getProperty("ocultar_browser"));
	}
	
	public static Properties lerArquivoPropriedades() {
		Properties propriedades = new Properties();
		 InputStream fileIn = ClassLoader.getSystemResourceAsStream(arquivo_propriedades);
		try {
			propriedades.load(fileIn);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return propriedades;
	}

}
