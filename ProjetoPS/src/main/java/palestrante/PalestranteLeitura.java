package palestrante;

import java.util.List;

public interface PalestranteLeitura extends PalestranteComponent {

	/**
	 * Le o arquivo de palestrantes e retorna uma lista de array de Strings com os dados lidos.
	 * 
	 * @param fileName O nome do arquivo que será lido
	 * @return uma lista de array de Strings com os dados lidos
	 */
	List<String[]> lerArquivoPalestrantes(String fileName);
	
}
