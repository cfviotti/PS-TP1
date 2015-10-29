package test.tratamento;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entidade.Palestra;
import entidade.Palestrante;
import palestra.PalestraLeitura;
import palestra.PalestraLeituraImpl;
import palestra.PalestraTratamento;
import palestra.PalestraTratamentoImpl;
import palestrante.PalestranteLeitura;
import palestrante.PalestranteLeituraImpl;
import palestrante.PalestranteTratamento;
import palestrante.PalestranteTratamentoImpl;

public class TratamentoTest {

	private PalestraLeitura palestraLeitura;
	private PalestranteLeitura palestranteLeitura;
	private PalestraTratamento palestraTratamento;
	private PalestranteTratamento palestranteTratamento;
	List<String[]> dadosPalestras;
	List<String[]> dadosPalestrantes;
	List<Palestra> palestras;
	List<Palestrante> palestrantes;

	@Before
	public void initialize() {
		palestraLeitura = new PalestraLeituraImpl();
		palestranteLeitura = new PalestranteLeituraImpl();
		palestraTratamento = new PalestraTratamentoImpl();
		palestranteTratamento = new PalestranteTratamentoImpl();
		dadosPalestras = palestraLeitura.lerArquivoPalestras("Palestras.txt");
		dadosPalestrantes = palestranteLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		palestras = palestraTratamento.tratarDadosPalestras(dadosPalestras);
		palestrantes = palestranteTratamento.tratarDadosPalestrantes(dadosPalestrantes);
	}
	
	@Test
	public void testTratarDadosPalestras() {
		assertTrue((palestraTratamento.tratarDadosPalestras(dadosPalestras)).toString().contains("Nome: NomePalestra1, " +
				                                                                       "Nome do Palestrante: Palestrante1, " +
				                                                                       "Tema: TemaPalestra1, " +
				                                                                       "Local: null, " +
				                                                                       "Duracao: 90 minutos, " +
				                                                                       "Data: Sem horario."));
	}
	
	@Test
	public void testTratarDadosPalestrantes() {
		assertTrue((palestranteTratamento.tratarDadosPalestrantes(dadosPalestrantes)).toString().contains("Nome: Palestrante1; " +
				                                                                 "Disponibilidade: Dia da semana: 3; " +
				                                                                 "Data de Inicio: Thu Jan 01 10:00:00 BRST 2015; " +
				                                                                 "Data de Fim: Thu Jan 01 12:00:00 BRST 2015; " +
				                                                                 "Disponivel toda semana: false; " +
				                                                                 "Dia da semana: 4; " +
				                                                                 "Data de Inicio: Wed Dec 31 08:00:00 BRST 2014; " +
				                                                                 "Data de Fim: Wed Dec 31 09:30:00 BRST 2014; " +
				                                                                 "Disponivel toda semana: true"));
	}

	@Test
	public void adicionarPalestrantes() {
		palestranteTratamento.adicionarPalestrantes(palestras, palestrantes);
		for (Palestra palestra : palestras) {
			assertNotNull(palestra.getPalestrante());
		}
	}
}
