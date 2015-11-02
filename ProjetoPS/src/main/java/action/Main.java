package action;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

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
		PalestraLeitura palestraLeitura = new PalestraLeituraImpl();
		PalestranteLeitura palestranteLeitura = new PalestranteLeituraImpl();
		LocalidadeLeitura localidadeLeitura = new LocalidadeLeituraImpl();
		PalestraTratamento palestraTratamento = new PalestraTratamentoImpl();
		PalestranteTratamento palestranteTratamento = new PalestranteTratamentoImpl();
		LocalidadeTratamento localidadeTratamento = new LocalidadeTratamentoImpl();
		CalendarioControle calendarioControle = new CalendarioControleImpl();
		CalendarioPersistencia calendarioPersistencia = new CalendarioPersistenciaImpl();
		List<String[]> dadosPalestras = palestraLeitura.lerArquivoPalestras("Palestras.txt");
		List<String[]> dadosPalestrantes = palestranteLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		List<String[]> dadosLocalidades = localidadeLeitura.lerArquivoLocalidades("Localidades.txt");
		List<Palestra> palestras = palestraTratamento.tratarDadosPalestras(dadosPalestras);
		List<Palestrante> palestrantes = palestranteTratamento.tratarDadosPalestrantes(dadosPalestrantes);
		List<Localidade> localidades = localidadeTratamento.tratarDadosLocalidades(dadosLocalidades);
		palestranteTratamento.adicionarPalestrantes(palestras, palestrantes);
		calendarioControle.alocarPalestras(palestras);
		calendarioControle.removerPalestrasSemHorario(palestras);
		calendarioControle.alocarLocalidades(localidades, palestras);
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
					Map<Integer, List<Palestra>> palestrasMap = calendarioControle.gerarMapaPalestras(palestras);
					String caminhoArquivo = calendarioPersistencia.imprimirArquivo(palestrasMap, fileName, opcao);
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