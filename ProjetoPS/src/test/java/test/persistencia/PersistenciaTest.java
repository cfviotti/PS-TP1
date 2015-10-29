package test.persistencia;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import calendario.CalendarioControle;
import calendario.CalendarioControleImpl;
import calendario.CalendarioPersistencia;
import calendario.CalendarioPersistenciaImpl;
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

public class PersistenciaTest {

	private PalestraLeitura palestraLeitura;
	private PalestranteLeitura palestranteLeitura;
	private PalestraTratamento palestraTratamento;
	private PalestranteTratamento palestranteTratamento;
	private CalendarioControle calendarioControle;
	private CalendarioPersistencia calendarioPersistencia;
	List<String[]> dadosPalestras;
	List<String[]> dadosPalestrantes;
	List<Palestra> palestras;
	List<Palestrante> palestrantes;
	Map<Integer, List<Palestra>> palestrasMap;

	@Before
	public void initialize() {
		palestraLeitura = new PalestraLeituraImpl();
		palestranteLeitura = new PalestranteLeituraImpl();
		palestraTratamento = new PalestraTratamentoImpl();
		palestranteTratamento = new PalestranteTratamentoImpl();
		calendarioControle = new CalendarioControleImpl();
		calendarioPersistencia = new CalendarioPersistenciaImpl();
		dadosPalestras = palestraLeitura.lerArquivoPalestras("Palestras.txt");
		dadosPalestrantes = palestranteLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		palestras = palestraTratamento.tratarDadosPalestras(dadosPalestras);
		palestrantes = palestranteTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		palestranteTratamento.adicionarPalestrantes(palestras, palestrantes);
		calendarioControle.alocarPalestras(palestras);
		calendarioControle.removerPalestrasSemHorario(palestras);
		palestrasMap = calendarioControle.gerarMapaPalestras(palestras);
	}
	
	@Test
	public void testImprimirArquivo() {
		String fileName = "CalendarioPalestras.txt";
		String filePath = calendarioPersistencia.imprimirArquivo(palestrasMap, fileName, 0);
		assertNotNull(filePath);
		filePath = calendarioPersistencia.imprimirArquivo(palestrasMap, fileName, 1);
		assertNotNull(filePath);
	}
	
}
