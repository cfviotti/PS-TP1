package localidade;

import java.util.List;

import entidade.Localidade;

public interface LocalidadeTratamento extends LocalidadeComponent {

	/**
	 * Trata os dados dos localidades, retornando uma lista de localidades.
	 * 
	 * @param dados Os dados das localidades
	 * @return uma lista de localidades
	 */
	List<Localidade> tratarDadosLocalidades(List<String[]> dados);
	
}
