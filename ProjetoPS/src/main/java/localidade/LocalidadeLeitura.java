package localidade;

import java.util.List;

public interface LocalidadeLeitura extends LocalidadeComponent {

	/**
	 * Lê o arquivo de localidades e retorna uma lista de array de Strings com os dados lidos.
	 * 
	 * @param fileName O nome do arquivo que será lido
	 * @return uma lista de array de Strings com os dados lidos
	 */
	List<String[]> lerArquivoLocalidades(String fileName);
	
}
