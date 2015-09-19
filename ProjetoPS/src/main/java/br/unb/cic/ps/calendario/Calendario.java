package br.unb.cic.ps.calendario;

import java.util.Calendar;

public interface Calendario {
	
	int buscarDiaSemana(String diaSemana);
	
	Calendar buscarDataInicio(String dataInicio, String horario);
	
	Calendar buscarDataFim(String dataFim, String horario);
	
	boolean isDisponivelTodaSemana(String data);
}
