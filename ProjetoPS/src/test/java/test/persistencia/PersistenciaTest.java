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
import entidade.Localidade;
import entidade.Palestra;
import entidade.Palestrante;
import localidade.LocalidadeLeitura;
import localidade.LocalidadeLeituraImpl;
import localidade.LocalidadeTratamento;
import localidade.LocalidadeTratamentoImpl;
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
	private LocalidadeLeitura localidadeLeitura;
	private PalestraTratamento palestraTratamento;
	private PalestranteTratamento palestranteTratamento;
	private LocalidadeTratamento localidadeTratamento;
	private CalendarioControle calendarioControle;
	private CalendarioPersistencia calendarioPersistencia;
	List<String[]> dadosPalestras;
	List<String[]> dadosPalestrantes;
	List<String[]> dadosLocalidades;
	List<Palestra> palestras;
	List<Palestrante> palestrantes;
	List<Localidade> localidades;
	Map<Integer, List<Palestra>> palestrasMap;

	@Before
	public void initialize() {
		palestraLeitura = new PalestraLeituraImpl();
		palestranteLeitura = new PalestranteLeituraImpl();
		localidadeLeitura = new LocalidadeLeituraImpl();
		palestraTratamento = new PalestraTratamentoImpl();
		palestranteTratamento = new PalestranteTratamentoImpl();
		localidadeTratamento = new LocalidadeTratamentoImpl();
		calendarioControle = new CalendarioControleImpl();
		calendarioPersistencia = new CalendarioPersistenciaImpl();
		dadosPalestras = palestraLeitura.lerArquivoPalestras("Palestras.txt");
		dadosPalestrantes = palestranteLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		dadosLocalidades = localidadeLeitura.lerArquivoLocalidades("Localidades.txt");
		palestras = palestraTratamento.tratarDadosPalestras(dadosPalestras);
		palestrantes = palestranteTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		localidades = localidadeTratamento.tratarDadosLocalidades(dadosLocalidades);
		palestranteTratamento.adicionarPalestrantes(palestras, palestrantes);
		calendarioControle.alocarPalestras(palestras);
		calendarioControle.removerPalestrasSemHorario(palestras);
		calendarioControle.alocarLocalidades(localidades, palestras);
		palestrasMap = calendarioControle.gerarMapaPalestras(palestras);
	}
	
	@Test
	public void testImprimirArquivo() {
		String filtro = "";
		String fileName = "CalendarioPalestras.txt";
		String filePath = calendarioPersistencia.imprimirArquivo(palestrasMap, fileName, 0, filtro);
		assertNotNull(filePath);
		filePath = calendarioPersistencia.imprimirArquivo(palestrasMap, fileName, 1, filtro);
		assertNotNull(filePath);
	}
	
}
