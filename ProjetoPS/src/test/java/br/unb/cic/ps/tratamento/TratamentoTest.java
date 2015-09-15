package br.unb.cic.ps.tratamento;

import org.junit.Test;

import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;
import junit.framework.TestCase;

public class TratamentoTest extends TestCase {

	Tratamento moduloTratamento = new TratamentoImpl();
	
	Leitura moduloLeitura = new LeituraImpl();
	
	@Test
	public void testTratamento() {
		assertTrue(moduloTratamento.tratamentoTest());
	}

	@Test
	public void testTratarDadosPalestras() {
		assertFalse(moduloTratamento.tratarDadosPalestras(
				moduloLeitura.lerArquivoPalestras("Palestras.txt")).isEmpty());
	}
	
	@Test
	public void testTratarDadosPalestrantes() {
		assertFalse(moduloTratamento.tratarDadosPalestrantes(
				moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt")).isEmpty());	
	}
	
}
