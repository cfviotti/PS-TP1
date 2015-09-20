package br.unb.cic.ps.tratamento;

import org.junit.Before;
import org.junit.Test;

import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TratamentoTest extends TestCase {

	Tratamento moduloTratamento = new TratamentoImpl();
	Leitura moduloLeitura = new LeituraImpl();
	
	List<String[]> dadosPalestras = new ArrayList<>();
	List<String[]> dadosPalestrantes = new ArrayList<>();

	@Before
	public void inicializando() {
		dadosPalestras = moduloLeitura.lerArquivoPalestras("PalestrasTeste.txt");
		dadosPalestrantes = moduloLeitura.lerArquivoPalestrantes("PalestrantesTeste.txt");
	}
	
	@Test
	public void testTratarDadosPalestras() {
		inicializando();
		assertTrue((moduloTratamento.tratarDadosPalestras(dadosPalestras)).toString().contains("Nome: NomePalestra1, " +
				                                                                       "Nome do Palestrante: Palestrante1, " +
				                                                                       "Tema: TemaPalestra1, " +
				                                                                       "Local: Local1, " +
				                                                                       "Duracao: 90 minutos, " +
				                                                                       "Data: Sem horario."));	
	}
	
	@Test
	public void testTratarDadosPalestrantes() {
		inicializando();
		assertTrue((moduloTratamento.tratarDadosPalestrantes(dadosPalestrantes)).toString().contains("Nome: Palestrante1; " +
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
		assertTrue(true);
	}
}
