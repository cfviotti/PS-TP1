package calendario;

import java.util.List;
import java.util.Map;

import entidade.Localidade;
import entidade.Palestra;

public interface CalendarioControle extends CalendarioComponent {

	/**
	 * Aloca as palestras, definindo suas datas de início e fim.
	 * 
	 * @param palestras As palestras que serão alocadas
	 */
	void alocarPalestras(List<Palestra> palestras);
	
	/**
	 * Remove as palestras sem horário.
	 * 
	 * @param palestras As palestras a serem removidas
	 */
	void removerPalestrasSemHorario(List<Palestra> palestras);
	
	/**
	 * Gera um mapa com as palestras vinculadas aos meses em que ocorrem.
	 * 
	 * @param palestras As palestras
	 * @return Um mapa de palestras, tendo como chave o mês em que as palestras ocorrem
	 */
	Map<Integer, List<Palestra>> gerarMapaPalestras(List<Palestra> palestras);

	/**
	 * Aloca as localidades com suas respectivas palestras.
	 * 
	 * @param localidades As localidades das palestras
	 * @param palestras As palestras
	 */
	void alocarLocalidades(List<Localidade> localidades, List<Palestra> palestras);
}
