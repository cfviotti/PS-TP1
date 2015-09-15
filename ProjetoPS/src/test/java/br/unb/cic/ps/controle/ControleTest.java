package br.unb.cic.ps.controle;

import org.junit.Test;

import junit.framework.TestCase;

public class ControleTest extends TestCase {

	Controle moduloControle = new ControleImpl();
	
	@Test
	public void testControle() {
		assertTrue(moduloControle.controleTest());
	}
}
