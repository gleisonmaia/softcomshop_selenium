package br.com.softcom.softcomshop.uteis;

import java.util.Random;
import java.util.UUID;

public class UtilAleatorio {

	Random random = new Random();
	UUID uuid = UUID.randomUUID();

	public String nomeProduto() {
		String strUuid = uuid.toString();
		return "Produto" + " " + strUuid;
	}

	public String gerarNome() {
		return gerarNome(true);
	}

	public String gerarNome(boolean comSobrenome) {
		String nomes[] = { "Arnaldo", "Felipe", "Tauan", "Pedrosa", "Alice", "Miguel", "Sophia", "Arthur", "Bruna",
				"Amanda", "Leona", "Carla", "Adriana", "Camila", "Eduarda", "Maria" };
		String sobrenomes[] = { "Almeida", "Alves", "Andrade", "Barbosa", "Barros", "Batista", "Campos", "Cardoso",
				"Oliveira", "Gomes", "Araújo", "Tavares", "Alencar", "Pessoa", "Costa" };
		String nome = nomes[random.nextInt(nomes.length)];
		String conector1 = " ", conector2 = " ";
		String sobrenome1 = "", sobrenome2 = "";

		if (comSobrenome == true) {

			sobrenome1 = sobrenomes[random.nextInt(sobrenomes.length)];
			// sobrenome1 não pode ser igual a sobrenome2
			do
				sobrenome2 = sobrenomes[random.nextInt(sobrenomes.length)];
			while (sobrenome1 == sobrenome2);

			if (random.nextInt(100) > 0 && random.nextInt(500) <= 200)
				conector1 = " de ";
			else if (random.nextInt(500) >= 300)
				conector2 = " de ";
		} else {
			conector1 = "";
			conector2 = "";
		}

		return nome + conector1 + sobrenome1 + conector2 + sobrenome2;
	}

	public String gerarNomeAssinado() {
		return gerarNomeAssinado(true);

	}

	public String gerarNomeAssinado(boolean comSobrenome) {
		return gerarNome(comSobrenome) + " " + gerarString(4, 1) + gerarString(1, 2);

	}

	public String gerarString() {
		return gerarString(6, 0);
	}

	public String gerarString(int tamanho) {
		return gerarString(tamanho, 0);
	}

	public String gerarString(int tamanho, int tipo) {

		String palavra = "";

		for (int i = 1; i <= tamanho; i++) {
			char letra = 0;

			switch (tipo) {
			case 0:
				letra = (char) (random.nextInt(26) + 'a');
				break;
			case 1:
				letra = (char) (random.nextInt(9) + '0');
				break;
			case 2:
				do
					letra = (char) (random.nextInt(11) + '!');
				while ((letra >= 39 && letra < 43) || letra == 34);
				break;
			}

			palavra = palavra + letra;

		}

		if (tipo == 0)
			palavra = palavra.substring(0, 1).toUpperCase() + palavra.substring(1);

		return palavra;
	}

	public String gerarStringAssinada() {

		return gerarString() + gerarString(4, 1);
	}

	public String gerarStringAssinada(int tamanho) {

		return gerarString(tamanho) + gerarString(4, 1);
	}
}
