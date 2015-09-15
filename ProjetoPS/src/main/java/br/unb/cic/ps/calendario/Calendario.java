package br.unb.cic.ps.calendario;

import java.util.List;

import br.unb.cic.ps.entidade.Palestrante;

public interface Calendario {

	boolean calendarTest();
	
	List<Palestrante> criarCalendarioPalestrantes(List<Palestrante> palestrantes);
}
