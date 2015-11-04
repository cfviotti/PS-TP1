package palestra;

import java.util.List;

public interface PalestraLeitura extends PalestraComponent {

	/**
	 * Le o arquivo de palestras e retorna uma lista de array de Strings com os dados lidos.
	 * 
	 * @param fileName O nome do arquivo que será lido
	 * @return uma lista de array de Strings com os dados lidos
	 */
	List<String[]> lerArquivoPalestras(String fileName);

}
