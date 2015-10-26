package calendario;

import java.util.Calendar;

public interface CalendarioTratamento extends CalendarioComponent {

	/**
	 * Busca um int correspondente ao dia da semana, de acordo com a API java.util.Calendar.
	 * 
	 * @param diaSemana, o dia da semana
	 * @return um int correspondente ao dia da semana
	 */
	int buscarDiaSemana(String diaSemana);
	
	/**
	 * Busca um Calendar representando a data de início, baseado nos parâmetros.
	 * 
	 * @param dataInicio, uma string representando a data de início
	 * @param horario, uma string representando o horário
	 * @return um Calendar representando a data de início
	 */
	Calendar buscarDataInicio(String dataInicio, String horario);
	
	/**
	 * Busca um Calendar representando a data de fim, baseado nos parâmetros.
	 * 
	 * @param dataFim, uma string representando a data de fim
	 * @param horario, uma string representando o horário
	 * @return um Calendar representando a data de fim
	 */
	Calendar buscarDataFim(String dataFim, String horario);
	
	/**
	 * Checa se está disponivel toda semana, de acordo com os parametros
	 * 
	 * @param data, uma string representando a data
	 * @return true, se é disponível toda semana, false se não é
	 */
	boolean isDisponivelTodaSemana(String data);
	
}
