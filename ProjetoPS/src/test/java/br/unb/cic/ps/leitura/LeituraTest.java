package br.unb.cic.ps.leitura;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class LeituraTest {

	private Leitura moduloLeitura;
	
	@Before
	public void initialize() {
		moduloLeitura = new LeituraImpl();
	}
	
	@Test
	public void testLerArquivoPalestras() {
		assertFalse(moduloLeitura.lerArquivoPalestras("Palestras.txt").isEmpty());
	}
	
	@Test
	public void testLerArquivoPalestrantes() {
		assertFalse(moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt").isEmpty());
	}
}
