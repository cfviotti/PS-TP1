package br.unb.cic.ps.persistencia;

import org.junit.Test;

import junit.framework.TestCase;

public class PersistenciaTest extends TestCase {

	@Test
	public void testPersistencia() {
		Persistencia moduloPersistencia = new PersistenciaImpl();
		assertTrue(moduloPersistencia.persistenciaTest());
	}

}
