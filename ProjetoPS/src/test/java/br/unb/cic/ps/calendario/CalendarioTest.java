package br.unb.cic.ps.calendario;

import org.junit.Test;

import junit.framework.TestCase;

public class CalendarioTest extends TestCase {

	@Test
	public void testCalendario() {
		Calendario moduloCalendario = new CalendarioImpl();
		assertTrue(moduloCalendario.calendarTest());
	}
	
}
