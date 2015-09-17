package br.unb.cic.ps.tratamento;

import org.junit.Test;

import junit.framework.TestCase;

public class TratamentoTest extends TestCase {

	Tratamento moduloTratamento = new TratamentoImpl();
		
	@Test
	public void testTratamento() {
		assertTrue(moduloTratamento.tratamentoTest());
	}
	
}
