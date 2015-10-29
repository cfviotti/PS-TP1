package entidade;

import java.util.Calendar;

/**
 * A classe Disponibilidade.
 */
public class Disponibilidade {
	
	private int diaSemana;

	private Calendar dataInicio;
	
	private Calendar dataFim;
	
	private boolean disponivelTodaSemana;
	
	@Override
	public String toString() {
		return "Dia da semana: " + diaSemana +
				"; Data de Inicio: " + dataInicio.getTime() +
				"; Data de Fim: " + dataFim.getTime() +
				"; Disponivel toda semana: " + disponivelTodaSemana + "; ";

	}

	/**
	 * Retorna uma instância de diaSemana.
	 * 
	 * @return uma instância de diaSemana
	 */
	public int getDiaSemana() {
		return diaSemana;
	}

	/**
	 * Atualizar uma instância de diaSemana.
	 * 
	 * @param diaSemana, o diaSemana
	 */
	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	/**
	 * Retorna uma instância de dataInicio.
	 * 
	 * @return uma instância de dataInicio
	 */
	public Calendar getDataInicio() {
		return dataInicio;
	}

	/**
	 * Atualizar uma instância de dataInicio.
	 * 
	 * @param dataInicio, o dataInicio
	 */
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * Retorna uma instância de dataFim.
	 * 
	 * @return uma instância de dataFim
	 */
	public Calendar getDataFim() {
		return dataFim;
	}

	/**
	 * Atualizar uma instância de dataFim.
	 * 
	 * @param dataFim, o dataFim
	 */
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	/**
	 * Checa se é disponivelTodaSemana.
	 * 
	 * @return o valor de disponivelTodaSemana
	 */
	public boolean isDisponivelTodaSemana() {
		return disponivelTodaSemana;
	}

	/**
	 * Atualizar uma instância de disponivelTodaSemana.
	 * 
	 * @param disponivelTodaSemana, o disponivelTodaSemana
	 */
	public void setDisponivelTodaSemana(boolean disponivelTodaSemana) {
		this.disponivelTodaSemana = disponivelTodaSemana;
	}
	
}