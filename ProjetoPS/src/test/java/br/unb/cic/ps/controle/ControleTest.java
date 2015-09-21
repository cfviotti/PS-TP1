package br.unb.cic.ps.controle;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;
import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;
import br.unb.cic.ps.tratamento.Tratamento;
import br.unb.cic.ps.tratamento.TratamentoImpl;

public class ControleTest {

	private Controle moduloControle;
	private Leitura moduloLeitura;
	private Tratamento moduloTratamento;
	private List<String[]> dadosPalestras;
	private List<String[]> dadosPalestrantes;
	private List<Palestra> palestras;
	private List<Palestrante> palestrantes;
	
	@Before
	public void initialize() {
		moduloControle = new ControleImpl();
		moduloLeitura = new LeituraImpl();
		moduloTratamento = new TratamentoImpl();
		dadosPalestras = moduloLeitura.lerArquivoPalestras("Palestras.txt");
		dadosPalestrantes = moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		palestras = moduloTratamento.tratarDadosPalestras(dadosPalestras);
		palestrantes = moduloTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		moduloTratamento.adicionarPalestrantes(palestras, palestrantes);
	}
	
	@Test
	public void testAlocarPalestras() {
		moduloControle.alocarPalestras(palestras);
		assertNotNull(palestras.get(0).getDataInicio());
	}
	
	@Test
	public void testRemoverPalestrasSemHorario() {
		moduloControle.alocarPalestras(palestras);
		moduloControle.removerPalestrasSemHorario(palestras);
		for (Palestra palestra : palestras) {
			assertNotNull(palestra.getDataInicio());
		}
	}
	
	@Test
	public void testGerarMapaPalestras() {
		moduloControle.removerPalestrasSemHorario(palestras);
		Map<Integer, List<Palestra>> palestrasMap = moduloControle.gerarMapaPalestras(palestras);
		assertNotNull(palestrasMap);
	}

}