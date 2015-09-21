package br.unb.cic.ps.tratamento;

import java.util.List;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;

/**
 * A Interface Tratamento.
 */
public interface Tratamento {

	/**
	 * Trata os dados das palestras, retornando uma lista de palestras.
	 * 
	 * @param dados, os dados das palestras
	 * @return uma lista de palestras
	 */
	List<Palestra> tratarDadosPalestras(List<String[]> dados);
	
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