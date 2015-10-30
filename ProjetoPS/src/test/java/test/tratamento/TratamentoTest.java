package test.tratamento;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

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

public class TratamentoTest {

	private PalestraLeitura palestraLeitura;
	private PalestranteLeitura palestranteLeitura;
	private LocalidadeLeitura localidadeLeitura;
	private PalestraTratamento palestraTratamento;
	private PalestranteTratamento palestranteTratamento;
	private LocalidadeTratamento localidadeTratamento;
	List<String[]> dadosPalestras;
	List<String[]> dadosPalestrantes;
	List<String[]> dadosLocalidades;
	List<Palestra> palestras;
	List<Palestrante> palestrantes;

	@Before
	public void initialize() {
		palestraLeitura = new PalestraLeituraImpl();
		palestranteLeitura = new PalestranteLeituraImpl();
		localidadeLeitura = new LocalidadeLeituraImpl();
		palestraTratamento = new PalestraTratamentoImpl();
		palestranteTratamento = new PalestranteTratamentoImpl();
		localidadeTratamento = new LocalidadeTratamentoImpl();
		dadosPalestras = palestraLeitura.lerArquivoPalestras("Palestras.txt");
		dadosPalestrantes = palestranteLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		dadosLocalidades = localidadeLeitura.lerArquivoLocalidades("Localidades.txt");
		palestras = palestraTratamento.tratarDadosPalestras(dadosPalestras);
		palestrantes = palestranteTratamento.tratarDadosPalestrantes(dadosPalestrantes);
	}
	
	@Test
	public void testTratarDadosPalestras() {
		assertNotNull(palestraTratamento.tratarDadosPalestras(dadosPalestras));
	}
	
	@Test
	public void testTratarDadosPalestrantes() {
		assertNotNull(palestranteTratamento.tratarDadosPalestrantes(dadosPalestrantes));
	}
	
	@Test
	public void testTratarDadosLocalidades() {
		assertNotNull(localidadeTratamento.tratarDadosLocalidades(dadosLocalidades));
	}
	
	@Test
	public void adicionarPalestrantes() {
		palestranteTratamento.adicionarPalestrantes(palestras, palestrantes);
		for (Palestra palestra : palestras) {
			assertNotNull(palestra.getPalestrante());
		}
	}
}
