package br.unb.cic.ps.entidade;

import java.util.Calendar;

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

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isDisponivelTodaSemana() {
		return disponivelTodaSemana;
	}

	public void setDisponivelTodaSemana(boolean disponivelTodaSemana) {
		this.disponivelTodaSemana = disponivelTodaSemana;
	}
	
}
