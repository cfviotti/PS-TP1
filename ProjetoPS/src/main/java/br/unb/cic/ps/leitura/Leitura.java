package br.unb.cic.ps.leitura;

import java.util.List;

/**
 * A Interface Leitura.
 */
public interface Leitura {

	/**
	 * A constante FILE_PATH.
	 */
	String FILE_PATH = "src/main/resources/arquivosTexto/";
	
	/**
	 * Le o arquivo de palestras e retorna uma lista de array de Strings com os dados lidos.
	 * 
	 * @param fileName, o nome do arquivo
	 * @return uma lista de array de Strings com os dados lidos
	 */
	List<String[]> lerArquivoPalestras(String fileName);
	
	/**
	 * Le o arquivo de palestrantes e retorna uma lista de array de Strings com os dados lidos.
	 * 
	 * @param fileName, o nome do arquivo
	 * @return uma lista de array de Strings com os dados lidos
	 */
	List<String[]> lerArquivoPalestrantes(String fileName);
	
}