package palestrante;

import java.util.List;

import br.unb.cic.ps.entidade.Palestrante;

public interface PalestranteTratamento extends PalestranteComponent {

	/**
	 * Trata os dados dos palestrantes, retornando uma lista de palestrantes.
	 * 
	 * @param dados, os dados dos palestrantes
	 * @return uma lista de palestrantes
	 */
	List<Palestrante> tratarDadosPalestrantes(List<String[]> dados);
	
}
