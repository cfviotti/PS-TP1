package br.unb.cic.ps.calendario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.unb.cic.ps.entidade.CalendarioDisponibilidade;
import br.unb.cic.ps.entidade.Disponibilidade;
import br.unb.cic.ps.entidade.Palestrante;

public class CalendarioImpl implements Calendario {

	@Override
	public boolean calendarTest() {
		return true;
	}

	@Override
	public List<Palestrante> criarCalendarioPalestrantes(List<Palestrante> palestrantes) {
		for (Palestrante palestrante : palestrantes) {
			for (Disponibilidade disponibilidade : palestrante.getDisponibilidades()) {
				CalendarioDisponibilidade calendarioDisponibilidade = new CalendarioDisponibilidade();
				Calendar dataInicio = Calendar.getInstance();
				Calendar dataFim = Calendar.getInstance();
				if (disponibilidade.getDiaSemana() != null && !disponibilidade.getDiaSemana().isEmpty()) {
					switch (disponibilidade.getDiaSemana()) {
						case "Dom":
							calendarioDisponibilidade.setDiaSemana(Calendar.SUNDAY);
							break;
						case "Seg":
							calendarioDisponibilidade.setDiaSemana(Calendar.MONDAY);			
							break;
						case "Ter":
							calendarioDisponibilidade.setDiaSemana(Calendar.TUESDAY);
							break;
						case "Qua":
							calendarioDisponibilidade.setDiaSemana(Calendar.WEDNESDAY);
							break;
						case "Qui":
							calendarioDisponibilidade.setDiaSemana(Calendar.THURSDAY);
							break;
						case "Sex":
							calendarioDisponibilidade.setDiaSemana(Calendar.FRIDAY);
							break;
						case "Sab":
							calendarioDisponibilidade.setDiaSemana(Calendar.SATURDAY);
							break;
					}
				}
				if (disponibilidade.getData() != null && !disponibilidade.getData().isEmpty()) {
					if (disponibilidade.getHorario() != null && !disponibilidade.getHorario().isEmpty()) {
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						try {
							dataInicio.setTime(dateFormat.parse(disponibilidade.getData()));
							dataFim.setTime(dateFormat.parse(disponibilidade.getData()));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						String[] horarios = disponibilidade.getHorario().split("-");
						String[] detalhesHorariosInicio = horarios[0].split(":");
						String[] detalhesHorariosFim = horarios[1].split(":");
						dataInicio.set(Calendar.HOUR_OF_DAY, Integer.valueOf(detalhesHorariosInicio[0]));
						dataInicio.set(Calendar.MINUTE, Integer.valueOf(detalhesHorariosInicio[1]));
						dataFim.set(Calendar.HOUR_OF_DAY, Integer.valueOf(detalhesHorariosFim[0]));
						dataFim.set(Calendar.MINUTE, Integer.valueOf(detalhesHorariosFim[1]));
					}
				}
				calendarioDisponibilidade.setDataInicio(dataInicio);
				calendarioDisponibilidade.setDataFim(dataFim);
				disponibilidade.setCalendarioDisponibilidade(calendarioDisponibilidade);
			}
		}
		return palestrantes;
	}
	
}
