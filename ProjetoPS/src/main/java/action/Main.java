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
		String fileName = "CalendarioPalestras.txt";
		palestranteTratamento.adicionarPalestrantes(palestras, palestrantes);
		calendarioControle.alocarPalestras(palestras);
		calendarioControle.removerPalestrasSemHorario(palestras);
		calendarioControle.alocarLocalidades(localidades, palestras);
		
		StringBuilder menuInicial = new StringBuilder();
		menuInicial.append("Deseja gerar o calendário para meses, dias ou anos?\n\n");
		menuInicial.append("0 - Meses\n");
		menuInicial.append("1 - Dias\n");
		menuInicial.append("2 - Anos\n");
		
		StringBuilder menuMeses = new StringBuilder();
		menuMeses.append("Escolha um dos meses para gerar o arquivo de palestras:\n\n");
		menuMeses.append("0 - Todos os meses\n");
		menuMeses.append("1 - Janeiro\n");
		menuMeses.append("2 - Fevereiro\n");
		menuMeses.append("3 - Marco\n");
		menuMeses.append("4 - Abril\n");
		menuMeses.append("5 - Maio\n");
		menuMeses.append("6 - Junho\n");
		menuMeses.append("7 - Julho\n");
		menuMeses.append("8 - Agosto\n");
		menuMeses.append("9 - Setembro\n");
		menuMeses.append("10 - Outubro\n");
		menuMeses.append("11 - Novembro\n");
		menuMeses.append("12 - Dezembro");
		
		StringBuilder menuDias = new StringBuilder();
		menuDias.append("Escolha um dia para gerar o arquivo de palestras:\n\n");
		
		StringBuilder menuAnos = new StringBuilder();
		menuAnos.append("Escolha um ano para gerar o arquivo de palestras:\n\n");
		
		StringBuilder menuEscolhido = new StringBuilder();		
		
		boolean opcaoValida = false;
		boolean subOpcaoValida = false;
		
		int limSuperior = 0;
		int limInferior = -1;
		
		do {
			String userInput = (String) JOptionPane.showInputDialog(null, menuInicial.toString(), "Organizador de Eventos", JOptionPane.QUESTION_MESSAGE);
			
			if (userInput != null && userInput.matches("^-?\\d+$")) {
				Integer opcao = Integer.valueOf(userInput);
				
				if (opcao > -1 && opcao < 4) {
					opcaoValida = true;
					
					switch(opcao) {
					
					case 0:						
						limSuperior = 13;
						menuEscolhido = menuMeses;
						break;
						
					case 1:						
						limSuperior = 32;
						menuEscolhido = menuDias;
						break;
						
					case 2:						
						limInferior = 1969;
						limSuperior = 2016;
						menuEscolhido = menuAnos;
						break;
						
					default:
						limSuperior = 31;
						menuEscolhido = menuMeses;						
						
					}
					
					do {						
						String userInputSubMenu = (String) JOptionPane.showInputDialog(null, menuEscolhido.toString(), "Organizador de Eventos", JOptionPane.QUESTION_MESSAGE);
						
						if (userInputSubMenu != null && userInput.matches("^-?\\d+$")) {
							Integer opcaoSubMenu = Integer.valueOf(userInputSubMenu);
							
							if (opcaoSubMenu > limInferior && opcaoSubMenu < limSuperior) {								
								
								subOpcaoValida = true;								
								Map<Integer, List<Palestra>> palestrasMap = calendarioControle.gerarMapaPalestras(palestras);					
								String caminhoArquivo = calendarioPersistencia.imprimirArquivo(palestrasMap, fileName, opcao);
								StringBuilder mensagemSucesso = new StringBuilder();
								mensagemSucesso.append("Arquivo " + fileName + " criado com sucesso!\n\n");
								mensagemSucesso.append("O arquivo se encontra no caminho:\n\n");
								mensagemSucesso.append(caminhoArquivo);
								JOptionPane.showMessageDialog(null, mensagemSucesso.toString(), "Sucesso", JOptionPane.INFORMATION_MESSAGE);
								
							} else {
								subOpcaoValida = false;
								StringBuilder mensagemErro = new StringBuilder();
								mensagemErro.append("A opcao " + opcaoSubMenu + " é inválida.\n\n");
								mensagemErro.append("Favor escolher uma opção válida!");
								JOptionPane.showMessageDialog(null, mensagemErro.toString(), "Erro", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							if (userInputSubMenu == null) {
								subOpcaoValida = true;
							} else {
								StringBuilder mensagemErro = new StringBuilder();
								mensagemErro.append("A opcao " + userInputSubMenu + " é inválida.\n\n");
								mensagemErro.append("Favor escolher uma opção válida!");
								JOptionPane.showMessageDialog(null, mensagemErro.toString() + " não é uma opção ", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}
					} while (!subOpcaoValida);					
					
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