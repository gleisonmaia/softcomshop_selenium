package br.com.softcom.softcomshop.uteis;

/* 
 * Classe com intuito de demonstrar exemplos de chamadas de fun��es das classes Uteis
*/

public class Exemplos {
	public static void main(String[] args) {

		/*
		 * // -------------------------------------------------------------------- //
		 * UtilCGC
		 * 
		 * UtilCGC cgc = new UtilCGC();
		 * 
		 * // Criar um CPF aleatorio String cpf = cgc.cpf(false);
		 * System.out.println("CPF: " + cpf);
		 * 
		 * // Criar um CNPJ aleatorio String cnpj = cgc.cnpj(true);
		 * System.out.println("CNPJ: " + cnpj);
		 * 
		 * // -------------------------------------------------------------------- //
		 * UtilLoremIpsum
		 * 
		 * UtilLoremIpsum lorem = new UtilLoremIpsum();
		 * 
		 * // Criar um texto Lorem Ipsum com com n caracteres ( String texto =
		 * lorem.getWords(5); System.out.println("Lorem(20): " + texto);
		 */

		// --------------------------------------------------------------------
		// UtilAleatorio

		UtilAleatorio aleatorio = new UtilAleatorio();

		/*
		 * // Criar nome de cliente String nome = aleatorio.gerarNome(false); String
		 * nomeCompleto = aleatorio.gerarNome(); System.out.println("Nome 1: '" + nome +
		 * "'"); System.out.println("Nome Completo 2: '" + nomeCompleto + "'");
		 * 
		 * // Criar nome de produto System.out.println(aleatorio.nomeProduto());
		 * 
		 * */
		 // Criar String quantidade, tipo: (0 - letra | 1 - número | 2 - especial)
		 System.out.println("Exemplo de String de tamanho 50: " +
		 aleatorio.gerarString(50)); System.out.println("Exemplo de String assinada: "
		 + aleatorio.gerarStringAssinada());
		 System.out.println("Exemplo de String assinada de tamanho 50: " +
		 aleatorio.gerarStringAssinada(50));
		 
		
		System.out.println(aleatorio.gerarString(8,1));
		System.out.println(aleatorio.gerarNomeAssinado());

	}
}
