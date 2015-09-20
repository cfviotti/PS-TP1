package br.unb.cic.ps.calendario;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CalendarioTest extends TestCase {
	
	private final static int DOMINGO = 1;
	private final static int SEGUNDA = 2;
	private final static int TERCA   = 3;
	private final static int QUARTA  = 4;
	private final static int QUINTA  = 5;
	private final static int SEXTA   = 6;
	private final static int SABADO  = 7;

	private Calendario moduloCalendario = new CalendarioImpl();
	
	@Test
	public void testBuscarDiaSemana() {
		assertTrue(moduloCalendario.buscarDiaSemana("Dom")==DOMINGO);
		assertTrue(moduloCalendario.buscarDiaSemana("Seg")==SEGUNDA);
		assertTrue(moduloCalendario.buscarDiaSemana("Ter")==TERCA  );
		assertTrue(moduloCalendario.buscarDiaSemana("Qua")==QUARTA );
		assertTrue(moduloCalendario.buscarDiaSemana("Qui")==QUINTA );
		assertTrue(moduloCalendario.buscarDiaSemana("Sex")==SEXTA  );
		assertTrue(moduloCalendario.buscarDiaSemana("Sab")==SABADO );
	}
	
	@Before
	public void inicializando() {
		Calendar calendarTest = Calendar.getInstance();
	}
	
	@Test
	public void testBuscarDataInicio() {
		assertTrue(true);
	}
	
	@Test
	public void testBuscarDataFim() {
		assertTrue(true);
	}
	
	@Test
	public void testIsDisponivelTodaSemana() {
		assertTrue(true);
	}
	
}
