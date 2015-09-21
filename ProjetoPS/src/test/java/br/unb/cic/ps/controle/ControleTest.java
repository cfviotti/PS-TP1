package br.unb.cic.ps.controle;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;
import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;
import br.unb.cic.ps.tratamento.Tratamento;
import br.unb.cic.ps.tratamento.TratamentoImpl;

import junit.framework.TestCase;

public class ControleTest extends TestCase {

	Controle   moduloControle   = new ControleImpl  ();
	Leitura    moduloLeitura    = new LeituraImpl   ();
	Tratamento moduloTratamento = new TratamentoImpl();
	
	List<Palestra>    palestras    = new ArrayList<Palestra>   ();
	List<Palestrante> palestrantes = new ArrayList<Palestrante>();
	
	@Before
	private void inicializar() {
		List<String[]> dadosPalestras    = moduloLeitura.lerArquivoPalestras   ("PalestrasTeste.txt"   );
		List<String[]> dadosPalestrantes = moduloLeitura.lerArquivoPalestrantes("PalestrantesTeste.txt");
		
		palestras    = moduloTratamento.tratarDadosPalestras   (dadosPalestras   );
		palestrantes = moduloTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		
		moduloTratamento.adicionarPalestrantes(palestras, palestrantes);
	}
	
	@Test
	public void testAlocarPalestras() {
		inicializar();
		moduloControle.alocarPalestras(palestras);
		assertTrue(true);
	}
	
	@Test
	public void testRemoverPalestrasSemHorario() {
		inicializar();
		moduloControle.removerPalestrasSemHorario(palestras);
		assertTrue(true);
	}
	
	@Test
	public void testGerarMapaPalestras() {
		inicializar();
		moduloControle.gerarMapaPalestras(palestras);
		assertTrue(true);
	}

}
