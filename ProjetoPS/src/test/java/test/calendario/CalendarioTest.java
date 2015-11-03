package test.calendario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import org.junit.Before;
import org.junit.Test;

import calendario.CalendarioTratamento;
import calendario.CalendarioTratamentoImpl;

public class CalendarioTest {
	
	private final static int DOMINGO = 1;
	private final static int SEGUNDA = 2;
	private final static int TERCA = 3;
	private final static int QUARTA = 4;
	private final static int QUINTA = 5;
	private final static int SEXTA = 6;
	private final static int SABADO = 7;
	
	private CalendarioTratamento calendarioTratamento;
	
	@Before
	public void initialize() {
		calendarioTratamento = new CalendarioTratamentoImpl();
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	
	public void testBuscarDataFimException() {
		new CalendarioTratamentoImpl().buscarDataFim("xx", "yy");
	}
	
	@Test(expected=java.lang.NumberFormatException.class)
	
	public void testBuscarDataInicioException() {
		new CalendarioTratamentoImpl().buscarDataInicio("xx", "yy");
	}
	
	@Test
	public void testBuscarDiaSemana() {
		assertTrue(calendarioTratamento.buscarDiaSemana("Sab") == SABADO);		
		assertTrue(calendarioTratamento.buscarDiaSemana("Dom") == DOMINGO);
		assertTrue(calendarioTratamento.buscarDiaSemana("Seg") == SEGUNDA);
		assertTrue(calendarioTratamento.buscarDiaSemana("Ter") == TERCA);
		assertTrue(calendarioTratamento.buscarDiaSemana("Qua") == QUARTA);
		assertTrue(calendarioTratamento.buscarDiaSemana("Qui") == QUINTA);
		assertTrue(calendarioTratamento.buscarDiaSemana("Sex") == SEXTA);		
		assertTrue(calendarioTratamento.buscarDiaSemana("Teste") == -1);		
	}
	
	@Test
	public void testBuscarDataInicio() {
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.set(Calendar.HOUR_OF_DAY, 15);
		dataInicio.set(Calendar.MINUTE, 42);
		dataInicio.set(Calendar.DAY_OF_MONTH, 2);
		dataInicio.set(Calendar.MONTH, 1);
		dataInicio.set(Calendar.YEAR, 2000);
		Calendar dataInicioCriada = calendarioTratamento.buscarDataInicio("02/02/2000", "15:42");
		assertEquals(dataInicio.get(Calendar.YEAR), dataInicioCriada.get(Calendar.YEAR));
		assertEquals(dataInicio.get(Calendar.MONTH), dataInicioCriada.get(Calendar.MONTH));
		assertEquals(dataInicio.get(Calendar.YEAR), dataInicioCriada.get(Calendar.YEAR));
		assertEquals(dataInicio.get(Calendar.DAY_OF_MONTH), dataInicioCriada.get(Calendar.DAY_OF_MONTH));
		assertEquals(dataInicio.get(Calendar.HOUR_OF_DAY), dataInicioCriada.get(Calendar.HOUR_OF_DAY));
		assertEquals(dataInicio.get(Calendar.MINUTE), dataInicioCriada.get(Calendar.MINUTE));
	}
	
	@Test
	public void testBuscarDataFim() {
		Calendar dataFim = Calendar.getInstance();
		dataFim.set(Calendar.HOUR_OF_DAY, 15);
		dataFim.set(Calendar.MINUTE, 43);
		dataFim.set(Calendar.DAY_OF_MONTH, 2);
		dataFim.set(Calendar.MONTH, 1);
		dataFim.set(Calendar.YEAR, 2000);
		Calendar dataFimCriada = calendarioTratamento.buscarDataFim("02/02/2000", "15:43-15:44");
		assertEquals(dataFim.get(Calendar.YEAR), dataFimCriada.get(Calendar.YEAR));
		assertEquals(dataFim.get(Calendar.MONTH), dataFimCriada.get(Calendar.MONTH));
		assertEquals(dataFim.get(Calendar.YEAR), dataFimCriada.get(Calendar.YEAR));
		assertEquals(dataFim.get(Calendar.DAY_OF_MONTH), dataFimCriada.get(Calendar.DAY_OF_MONTH));
		assertEquals(dataFim.get(Calendar.HOUR_OF_DAY), dataFimCriada.get(Calendar.HOUR_OF_DAY));		
	}
	
	@Test
	public void testIsDisponivelTodaSemana() {
		assertTrue(calendarioTratamento.isDisponivelTodaSemana("00/01/2000"));
		assertFalse(calendarioTratamento.isDisponivelTodaSemana("01/01/2000"));
	}
	
}