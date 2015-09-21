package br.unb.cic.ps.tratamento;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;
import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;

public class TratamentoTest {

	Leitura moduloLeitura;
	Tratamento moduloTratamento;
	List<String[]> dadosPalestras;
	List<String[]> dadosPalestrantes;
	List<Palestra> palestras;
	List<Palestrante> palestrantes;

	@Before
	public void initialize() {
		moduloLeitura = new LeituraImpl();
		moduloTratamento = new TratamentoImpl();
		dadosPalestras = moduloLeitura.lerArquivoPalestras("Palestras.txt");
		dadosPalestrantes = moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		palestras = moduloTratamento.tratarDadosPalestras(dadosPalestras);
		palestrantes = moduloTratamento.tratarDadosPalestrantes(dadosPalestrantes);
	}
	
	@Test
	public void testTratarDadosPalestras() {
		assertTrue((moduloTratamento.tratarDadosPalestras(dadosPalestras)).toString().contains("Nome: NomePalestra1, " +
				                                                                       "Nome do Palestrante: Palestrante1, " +
				                                                                       "Tema: TemaPalestra1, " +
				                                                                       "Local: Local1, " +
				                                                                       "Duracao: 90 minutos, " +
				                                                                       "Data: Sem horario."));	
	}
	
	@Test
	public void testTratarDadosPalestrantes() {
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
		moduloTratamento.adicionarPalestrantes(palestras, palestrantes);
		for (Palestra palestra : palestras) {
			assertNotNull(palestra.getPalestrante());
		}
	}
}
