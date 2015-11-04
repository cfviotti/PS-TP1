package palestra;

import java.util.List;

import entidade.Palestra;

public interface PalestraTratamento extends PalestraComponent {

	/**
	 * Trata os dados das palestras, retornando uma lista de palestras.
	 * 
	 * @param dados os dados das palestras
	 * @return uma lista de palestras
	 */
	List<Palestra> tratarDadosPalestras(List<String[]> dados);
	
}
