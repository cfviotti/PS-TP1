package br.unb.cic.ps.leitura;

import org.junit.Test;

import junit.framework.TestCase;

public class LeituraTest extends TestCase {

	private Leitura moduloLeitura = new LeituraImpl();
	
	@Test
	public void testLerArquivoPalestras() {
		assertFalse(moduloLeitura.lerArquivoPalestras("Palestras.txt").isEmpty());
	}
	
	@Test
	public void testLerArquivoPalestrantes() {
		assertFalse(moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt").isEmpty());
	}
}
