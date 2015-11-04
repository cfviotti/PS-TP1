package palestrante;

import java.util.List;

import entidade.Palestra;
import entidade.Palestrante;

public interface PalestranteTratamento extends PalestranteComponent {

	/**
	 * Trata os dados dos palestrantes, retornando uma lista de palestrantes.
	 * 
	 * @param dados Os dados dos palestrantes
	 * @return uma lista de palestrantes
	 */
	List<Palestrante> tratarDadosPalestrantes(List<String[]> dados);
	
	/**
	 * Adiciona os palestrantes às suas respectivas palestras.
	 * 
	 * @param palestras A palestra na qual serão adicionados palestrante
	 * @param palestrantes Os Palestrantes que serão adicionados
	 */
	void adicionarPalestrantes(List<Palestra> palestras, List<Palestrante> palestrantes);
	
}
