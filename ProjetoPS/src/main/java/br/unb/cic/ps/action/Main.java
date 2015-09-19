package br.unb.cic.ps.action;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.unb.cic.ps.controle.Controle;
import br.unb.cic.ps.controle.ControleImpl;
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
		Persistencia moduloPersistencia = new PersistenciaImpl();
		Controle moduloControle = new ControleImpl();
		System.out.println("Palestras (Modulo Leitura):");
		List<String[]> dadosPalestras = moduloLeitura.lerArquivoPalestras("Palestras.txt");
		for (int i = 0; i < dadosPalestras.size(); i++) {
			for (int j = 0; j < dadosPalestras.get(i).length; j++) {
				System.out.print(dadosPalestras.get(i)[j] + " ");
			}
			System.out.println();
		}
		System.out.println("Palestrantes (Modulo Leitura):");
		List<String[]> dadosPalestrantes = moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		for (int i = 0; i < dadosPalestrantes.size(); i++) {
			for (int j = 0; j < dadosPalestrantes.get(i).length; j++) {
				System.out.print(dadosPalestrantes.get(i)[j] + " ");
			}
			System.out.println();
		}
		System.out.println("Palestras (Modulo Tratamento):");
		List<Palestra> palestras = moduloTratamento.tratarDadosPalestras(dadosPalestras);
		for (Palestra palestra : palestras) {
			System.out.println(palestra);
		}
		System.out.println("Palestrantes (Modulo Tratamento):");
		List<Palestrante> palestrantes = moduloTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		for (Palestrante palestrante : palestrantes) {
			System.out.println(palestrante);
		}
		System.out.println("Palestras (Modulo Tratamento):");
		moduloTratamento.adicionarPalestrantes(palestras, palestrantes);
		for (Palestra palestra : palestras) {
			System.out.println(palestra);
		}
		System.out.println("Palestras (Modulo Controle):");
		moduloControle.alocarPalestras(palestras);
		moduloControle.removerPalestrasSemHorario(palestras);
		for (Palestra palestra : palestras) {
			System.out.println(palestra);
		}
		System.out.println("\n");
		System.out.println("###########################################################");
		System.out.println("# Escolha um dos meses para gerar o arquivo de palestras: #");
		System.out.println("###########################################################\n\n");
		System.out.println("0 - Todos os meses");
		System.out.println("1 - Janeiro");
		System.out.println("2 - Fevereiro");
		System.out.println("3 - Marco");
		System.out.println("4 - Abril");
		System.out.println("5 - Maio");
		System.out.println("6 - Junho");
		System.out.println("7 - Julho");
		System.out.println("8 - Agosto");
		System.out.println("9 - Setembro");
		System.out.println("10 - Outubro");
		System.out.println("11 - Novembro");
		System.out.println("12 - Dezembro");
		Scanner scanner = new Scanner(System.in);
		Integer opcao = Integer.valueOf(scanner.next());
		System.out.println("Chamando o Modulo Persistencia...");
		String fileName = "CalendarioPalestras.txt";
		Map<Integer, List<Palestra>> palestrasMap = moduloControle.gerarMapaPalestras(palestras);
		moduloPersistencia.imprimirArquivo(palestrasMap, fileName, opcao);
		System.out.println("Arquivo " + fileName + " criado.");
		scanner.close();
	}
	
}
