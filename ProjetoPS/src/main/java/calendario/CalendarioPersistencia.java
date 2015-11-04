package calendario;

import java.util.List;
import java.util.Map;

import entidade.Palestra;

public interface CalendarioPersistencia extends CalendarioComponent {

	/**
	 * Imprime um arquivo com os dados das palestras e palestrantes organizados, e retorna uma String com o Path do arquivo gerado.
	 * 
	 * @param palestras As palestras
	 * @param fileName O nome do arquivo que será lido
	 * @param opcao A opção referente ao mês escolhido
	 * @return uma String com o Path do arquivo gerado
	 */
	String imprimirArquivo(Map<Integer, List<Palestra>> palestras, String fileName, Integer opcao);
	
}
