package test.controle;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import calendario.CalendarioControle;
import calendario.CalendarioControleImpl;
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

public class ControleTest {

	private PalestraLeitura palestraLeitura;
	private PalestranteLeitura palestranteLeitura;
	private PalestraTratamento palestraTratamento;
	private PalestranteTratamento palestranteTratamento;
	private CalendarioControle calendarioControle;
	private List<String[]> dadosPalestras;
	private List<String[]> dadosPalestrantes;
	private List<Palestra> palestras;
	private List<Palestrante> palestrantes;
	
	@Before
	public void initialize() {
		palestraLeitura = new PalestraLeituraImpl();
		palestranteLeitura = new PalestranteLeituraImpl();
		palestraTratamento = new PalestraTratamentoImpl();
		palestranteTratamento = new PalestranteTratamentoImpl();
		calendarioControle = new CalendarioControleImpl();
		dadosPalestras = palestraLeitura.lerArquivoPalestras("Palestras.txt");
		dadosPalestrantes = palestranteLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		palestras = palestraTratamento.tratarDadosPalestras(dadosPalestras);
		palestrantes = palestranteTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		palestranteTratamento.adicionarPalestrantes(palestras, palestrantes);
	}
	
	@Test
	public void testAlocarPalestras() {
		calendarioControle.alocarPalestras(palestras);
		assertNotNull(palestras.get(0).getDataInicio());
	}
	
	@Test
	public void testRemoverPalestrasSemHorario() {
		calendarioControle.alocarPalestras(palestras);
		calendarioControle.removerPalestrasSemHorario(palestras);
		for (Palestra palestra : palestras) {
			assertNotNull(palestra.getDataInicio());
		}
	}
	
	@Test
	public void testGerarMapaPalestras() {
		calendarioControle.removerPalestrasSemHorario(palestras);
		Map<Integer, List<Palestra>> palestrasMap = calendarioControle.gerarMapaPalestras(palestras);
		assertNotNull(palestrasMap);
	}

}