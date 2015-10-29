package palestrante;

import java.util.List;

import entidade.Palestra;
import entidade.Palestrante;

public interface PalestranteTratamento extends PalestranteComponent {

	/**
	 * Trata os dados dos palestrantes, retornando uma lista de palestrantes.
	 * 
	 * @param dados, os dados dos palestrantes
	 * @return uma lista de palestrantes
	 */
	List<Palestrante> tratarDadosPalestrantes(List<String[]> dados);
	
	/**
	 * Adiciona os palestrantes às suas respectivas palestras.
	 * 
	 * @param palestras, as palestras
	 * @param palestrantes, os palestrantes
	 */
	void adicionarPalestrantes(List<Palestra> palestras, List<Palestrante> palestrantes);
	
}
