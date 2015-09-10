package br.unb.cic.ps.tratamento;

import org.junit.Test;

import junit.framework.TestCase;

public class TratamentoTest extends TestCase {

	@Test
	public void testTratamento() {
		Tratamento moduloTratamento = new TratamentoImpl();
		assertTrue(moduloTratamento.tratamentoTest());
	}

}
