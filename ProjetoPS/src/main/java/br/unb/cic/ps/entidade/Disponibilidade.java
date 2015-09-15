package br.unb.cic.ps.entidade;

public class Disponibilidade {

	private String diaSemana;
	
	private String data;
	
	private String horario;
	
	private CalendarioDisponibilidade calendarioDisponibilidade;

	public String getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public CalendarioDisponibilidade getCalendarioDisponibilidade() {
		return calendarioDisponibilidade;
	}

	public void setCalendarioDisponibilidade(CalendarioDisponibilidade calendarioDisponibilidade) {
		this.calendarioDisponibilidade = calendarioDisponibilidade;
	}
	
}
