package localidade;

import java.util.List;

public interface LocalidadeLeitura extends LocalidadeComponent {

	/**
	 * Le o arquivo de localidades e retorna uma lista de array de Strings com os dados lidos.
	 * 
	 * @param fileName, o nome do arquivo
	 * @return uma lista de array de Strings com os dados lidos
	 */
	List<String[]> lerArquivoLocalidades(String fileName);
	
}
