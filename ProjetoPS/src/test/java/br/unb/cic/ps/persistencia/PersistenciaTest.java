package br.unb.cic.ps.persistencia;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import br.unb.cic.ps.controle.Controle;
import br.unb.cic.ps.controle.ControleImpl;
import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;
import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;
import br.unb.cic.ps.tratamento.Tratamento;
import br.unb.cic.ps.tratamento.TratamentoImpl;

public class PersistenciaTest {

	Leitura moduloLeitura;
	Tratamento moduloTratamento;
	Controle moduloControle;
	Persistencia moduloPersistencia;
	List<String[]> dadosPalestras;
	List<String[]> dadosPalestrantes;
	List<Palestra> palestras;
	List<Palestrante> palestrantes;
	Map<Integer, List<Palestra>> palestrasMap;

	@Before
	public void initialize() {
		moduloLeitura = new LeituraImpl();
		moduloTratamento = new TratamentoImpl();
		moduloControle = new ControleImpl();
		moduloPersistencia = new PersistenciaImpl();
		dadosPalestras = moduloLeitura.lerArquivoPalestras("Palestras.txt");
		dadosPalestrantes = moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		palestras = moduloTratamento.tratarDadosPalestras(dadosPalestras);
		palestrantes = moduloTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		moduloTratamento.adicionarPalestrantes(palestras, palestrantes);
		moduloControle.alocarPalestras(palestras);
		moduloControle.removerPalestrasSemHorario(palestras);
		palestrasMap = moduloControle.gerarMapaPalestras(palestras);
	}
	
	@Test
	public void testImprimirArquivo() {
		String fileName = "CalendarioPalestras.txt";
		String filePath = moduloPersistencia.imprimirArquivo(palestrasMap, fileName, 0);
		assertNotNull(filePath);
		filePath = moduloPersistencia.imprimirArquivo(palestrasMap, fileName, 1);
		assertNotNull(filePath);
	}
	
}
