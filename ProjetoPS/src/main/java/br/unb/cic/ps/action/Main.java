package br.unb.cic.ps.action;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

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

/**
 * Classe Main.
 */
public class Main {

	/**
	 * Método main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Leitura moduloLeitura = new LeituraImpl();
		Tratamento moduloTratamento = new TratamentoImpl();
		Controle moduloControle = new ControleImpl();
		Persistencia moduloPersistencia = new PersistenciaImpl();
		List<String[]> dadosPalestras = moduloLeitura.lerArquivoPalestras("Palestras.txt");
		List<String[]> dadosPalestrantes = moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		List<Palestra> palestras = moduloTratamento.tratarDadosPalestras(dadosPalestras);
		List<Palestrante> palestrantes = moduloTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		moduloTratamento.adicionarPalestrantes(palestras, palestrantes);
		moduloControle.alocarPalestras(palestras);
		moduloControle.removerPalestrasSemHorario(palestras);
		StringBuilder menuOpcoes = new StringBuilder();
		menuOpcoes.append("Escolha um dos meses para gerar o arquivo de palestras:\n\n");
		menuOpcoes.append("0 - Todos os meses\n");
		menuOpcoes.append("1 - Janeiro\n");
		menuOpcoes.append("2 - Fevereiro\n");
		menuOpcoes.append("3 - Marco\n");
		menuOpcoes.append("4 - Abril\n");
		menuOpcoes.append("5 - Maio\n");
		menuOpcoes.append("6 - Junho\n");
		menuOpcoes.append("7 - Julho\n");
		menuOpcoes.append("8 - Agosto\n");
		menuOpcoes.append("9 - Setembro\n");
		menuOpcoes.append("10 - Outubro\n");
		menuOpcoes.append("11 - Novembro\n");
		menuOpcoes.append("12 - Dezembro");
		boolean opcaoValida = false;
		do {
			String userInput = (String) JOptionPane.showInputDialog(null, menuOpcoes.toString(), "Organizador de Eventos", JOptionPane.QUESTION_MESSAGE);
			if (userInput != null && userInput.matches("^-?\\d+$")) {
				Integer opcao = Integer.valueOf(userInput);
				if (opcao > -1 && opcao < 13) {
					opcaoValida = true;
					String fileName = "CalendarioPalestras.txt";
					Map<Integer, List<Palestra>> palestrasMap = moduloControle.gerarMapaPalestras(palestras);
					String caminhoArquivo = moduloPersistencia.imprimirArquivo(palestrasMap, fileName, opcao);
					StringBuilder mensagemSucesso = new StringBuilder();
					mensagemSucesso.append("Arquivo " + fileName + " criado com sucesso!\n\n");
					mensagemSucesso.append("O arquivo se encontra no caminho:\n\n");
					mensagemSucesso.append(caminhoArquivo);
					JOptionPane.showMessageDialog(null, mensagemSucesso.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} else {
					opcaoValida = false;
					StringBuilder mensagemErro = new StringBuilder();
					mensagemErro.append("A opcao " + opcao + " é inválida.\n\n");
					mensagemErro.append("Favor escolher uma opção válida!");
					JOptionPane.showMessageDialog(null, mensagemErro.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				if (userInput == null) {
					opcaoValida = true;
				} else {
					StringBuilder mensagemErro = new StringBuilder();
					mensagemErro.append("A opcao " + userInput + " é inválida.\n\n");
					mensagemErro.append("Favor escolher uma opção válida!");
					JOptionPane.showMessageDialog(null, mensagemErro.toString() + " não é uma opção ", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		} while (!opcaoValida);
	}
	
}