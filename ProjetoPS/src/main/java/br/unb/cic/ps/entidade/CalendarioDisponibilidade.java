package br.unb.cic.ps.entidade;

import java.util.Calendar;

public class CalendarioDisponibilidade {

	private int diaSemana;

	private Calendar dataInicio;
	
	private Calendar dataFim;

	@Override
	public String toString() {
		return "Dia da semana: " + diaSemana +
				"; Data de Inicio: " + dataInicio.getTime() +
				"; Data de Fim: " + dataFim.getTime();
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
	
}
