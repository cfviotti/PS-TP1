package br.unb.cic.ps.calendario;

import org.junit.Test;

import junit.framework.TestCase;

public class CalendarioTest extends TestCase {

	Calendario moduloCalendario = new CalendarioImpl();
	
	@Test
	public void testCalendario() {
		assertTrue(moduloCalendario.calendarTest());
	}
	
	
	
}
