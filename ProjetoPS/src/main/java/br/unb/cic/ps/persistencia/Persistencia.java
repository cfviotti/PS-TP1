package br.unb.cic.ps.persistencia;

import java.util.List;
import java.util.Map;

import br.unb.cic.ps.entidade.Palestra;

/**
 * A Interface Persistencia.
 */
public interface Persistencia {

	/**
	 * A constante FILE_PATH.
	 */
	String FILE_PATH = "src/main/resources/arquivosTexto/";
	
	/**
	 * Imprime um arquivo com os dados das palestras e palestrantes organizados, e retorna uma String com o Path do arquivo gerado.
	 * 
	 * @param palestras, as palestras
	 * @param fileName, o nome do arquivo
	 * @param opcao, a opcao referente ao mês escolhido
	 * @return uma String com o Path do arquivo gerado
	 */
	String imprimirArquivo(Map<Integer, List<Palestra>> palestras, String fileName, Integer opcao);
	
}