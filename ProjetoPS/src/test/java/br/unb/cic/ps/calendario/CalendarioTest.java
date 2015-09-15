package br.unb.cic.ps.calendario;

import org.junit.Test;

import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;
import br.unb.cic.ps.tratamento.Tratamento;
import br.unb.cic.ps.tratamento.TratamentoImpl;
import junit.framework.TestCase;

public class CalendarioTest extends TestCase {

	Calendario moduloCalendario = new CalendarioImpl();
	
	Tratamento moduloTratamento = new TratamentoImpl();
	
	Leitura moduloLeitura = new LeituraImpl();
	
	@Test
	public void testCalendario() {
		assertTrue(moduloCalendario.calendarTest());
	}
	
	@Test
	public void testcriarCalendarioPalestrantes() {
		assertFalse(moduloCalendario.criarCalendarioPalestrantes(
				moduloTratamento.tratarDadosPalestrantes(
						moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt"))).isEmpty());
	}
	
}
