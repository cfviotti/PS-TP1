package br.unb.cic.ps.leitura;

import org.junit.Test;

import junit.framework.TestCase;

public class LeituraTest extends TestCase {

	@Test
	public void testLeitura() {
		Leitura moduloLeitura = new LeituraImpl();
		assertTrue(moduloLeitura.leituraTest());
	}
}
