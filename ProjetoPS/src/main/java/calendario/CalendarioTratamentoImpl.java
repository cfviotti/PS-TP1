package calendario;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarioTratamentoImpl implements CalendarioTratamento {

	@Override
	public int buscarDiaSemana(String diaSemana) {
		int diaSemanaInt = -1;
		switch (diaSemana) {
			case "Dom":
				diaSemanaInt = Calendar.SUNDAY;
				break;
			case "Seg":
				diaSemanaInt = Calendar.MONDAY;
				break;
			case "Ter":
				diaSemanaInt = Calendar.TUESDAY;
				break;
			case "Qua":
				diaSemanaInt = Calendar.WEDNESDAY;
				break;
			case "Qui":
				diaSemanaInt = Calendar.THURSDAY;
				break;
			case "Sex":
				diaSemanaInt = Calendar.FRIDAY;
				break;
			case "Sab":
				diaSemanaInt = Calendar.SATURDAY;
				break;
		}
		return diaSemanaInt;
	}

	@Override
	public Calendar buscarDataInicio(String dataInicio, String horario) {
		Calendar dataInicioCalendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataInicioCalendar.setTime(dateFormat.parse(dataInicio));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String[] horarios = horario.split("-");
		String[] detalhesHorariosInicio = horarios[0].split(":");
		dataInicioCalendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(detalhesHorariosInicio[0]));
		dataInicioCalendar.set(Calendar.MINUTE, Integer.valueOf(detalhesHorariosInicio[1]));
		return dataInicioCalendar;
	}

	@Override
	public Calendar buscarDataFim(String dataFim, String horario) {
		Calendar dataFimCalendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataFimCalendar.setTime(dateFormat.parse(dataFim));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		String[] horarios = horario.split("-");
		String[] detalhesHorariosFim = horarios[1].split(":");
		dataFimCalendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(detalhesHorariosFim[0]));
		dataFimCalendar.set(Calendar.MINUTE, Integer.valueOf(detalhesHorariosFim[1]));
		return dataFimCalendar;
	}

	@Override
	public boolean isDisponivelTodaSemana(String data) {
		String[] dataSplit = data.split("/");
		if (dataSplit[0].equals("00")) {
			return true;
		}
		return false;
	}
	
}
