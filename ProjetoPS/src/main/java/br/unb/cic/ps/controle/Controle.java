package br.unb.cic.ps.controle;

import java.util.List;
import java.util.Map;

import br.unb.cic.ps.entidade.Palestra;

/**
 * A interface Controle.
 */
public interface Controle {

	/**
	 * Aloca as palestras, definindo suas datas de início e fim.
	 * 
	 * @param palestras, as palestras
	 */
	void alocarPalestras(List<Palestra> palestras);
	
	/**
	 * Remove as palestras sem horário.
	 * 
	 * @param palestras, as palestras
	 */
	void removerPalestrasSemHorario(List<Palestra> palestras);
	
	/**
	 * Gera um mapa com as palestras vinculadas aos meses em que ocorrem.
	 * 
	 * @param palestras, as palestras
	 * @return um mapa de palestras, tendo como chave o mês em que as palestras ocorrem
	 */
	Map<Integer, List<Palestra>> gerarMapaPalestras(List<Palestra> palestras);

}