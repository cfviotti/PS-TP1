package br.unb.cic.ps.persistencia;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PersistenciaTest {

	Persistencia moduloPersistencia;

	@Before
	public void initialize() {
		moduloPersistencia = new PersistenciaImpl();
	}
	
	@Test
	public void testImprimirArquivo() {
		assertTrue(true);
	}
	
}
