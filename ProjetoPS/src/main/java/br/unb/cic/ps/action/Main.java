package br.unb.cic.ps.action;

import java.util.List;

import br.unb.cic.ps.calendario.Calendario;
import br.unb.cic.ps.calendario.CalendarioImpl;
import br.unb.cic.ps.entidade.Disponibilidade;
import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;
import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;
import br.unb.cic.ps.persistencia.Persistencia;
import br.unb.cic.ps.persistencia.PersistenciaImpl;
import br.unb.cic.ps.tratamento.Tratamento;
import br.unb.cic.ps.tratamento.TratamentoImpl;

public class Main {

	public static void main(String[] args) {
		Leitura moduloLeitura = new LeituraImpl();
		Tratamento moduloTratamento = new TratamentoImpl();
		Calendario moduloCalendario = new CalendarioImpl();
		Persistencia moduloPersistencia = new PersistenciaImpl();
		System.out.println("Palestras (Modulo Leitura):");
		List<String[]> dadosPalestras = moduloLeitura.lerArquivoPalestras("Palestras.txt");
		for (int i = 0; i < dadosPalestras.size(); i++) {
			for (int j = 0; j < dadosPalestras.get(i).length; j++) {
				System.out.print(dadosPalestras.get(i)[j] + " ");
			}
			System.out.println();
		}
		System.out.println("Palestras (Modulo Tratamento):");
		List<Palestra> palestras = moduloTratamento.tratarDadosPalestras(dadosPalestras);
		for (Palestra palestra : palestras) {
			System.out.println(palestra);
		}
		System.out.println("Palestrantes (Modulo Leitura):");
		List<String[]> dadosPalestrantes = moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		for (int i = 0; i < dadosPalestrantes.size(); i++) {
			for (int j = 0; j < dadosPalestrantes.get(i).length; j++) {
				System.out.print(dadosPalestrantes.get(i)[j] + " ");
			}
			System.out.println();
		}
		System.out.println("Palestrantes (Modulo Tratamento):");
		List<Palestrante> palestrantes = moduloTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		for (Palestrante palestrante : palestrantes) {
			System.out.println(palestrante);
		}
		System.out.println("Palestrantes (Modulo Calendario):");
		palestrantes = moduloCalendario.criarCalendarioPalestrantes(palestrantes);
		for (Palestrante palestrante : palestrantes) {
			System.out.println(palestrante);
			for (Disponibilidade disponibilidade : palestrante.getDisponibilidades()) {
				System.out.println(disponibilidade.getCalendarioDisponibilidade());
			}
		}
		System.out.println("Palestrantes (Modulo Persistencia):");
		for (Palestra palestra : palestras) {
			for (Palestrante palestrante : palestrantes) {
				if (palestra.getPalestrante() != null && palestra.getPalestrante().getNome() != null) {
					if (palestra.getPalestrante().getNome().equals(palestrante.getNome())) {
						palestra.setPalestrante(palestrante);
					}
				}
			}
		}
		moduloPersistencia.imprimirArquivo(palestras, "output.txt");
	}
	
}
