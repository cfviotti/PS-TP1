package br.unb.cic.ps.persistencia;

import br.unb.cic.ps.calendario.Calendario;
import br.unb.cic.ps.calendario.CalendarioImpl;

public class PersistenciaImpl implements Persistencia {

	private Calendario moduloCalendario = new CalendarioImpl();
	
}
