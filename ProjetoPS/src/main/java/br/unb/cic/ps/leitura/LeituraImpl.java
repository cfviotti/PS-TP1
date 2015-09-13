package br.unb.cic.ps.leitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;

public class LeituraImpl implements Leitura {

	@Override
	public boolean leituraTest() {
		return true;
	}

	@Override
	public List<Palestra> lerArquivoPalestras(String fileName) {
		List<Palestra> palestras = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH + fileName))) {
			Palestra palestra = new Palestra();
			String currentLine;
			while ((currentLine = bufferedReader.readLine()) != null) {
				String[] line = currentLine.trim().replaceAll("\\.", "").split(" ");
				switch (line[0]) {
					case "Nome:":
						palestra.setNome(line[1]);
						for (int i = 2; i < line.length; i++) {
							palestra.setNome(palestra.getNome() + " " + line[i]);
						}
						break;
					case "Palestrante:":
						Palestrante palestrante = new Palestrante();
						palestrante.setNome(line[1]);
						for (int i = 2; i < line.length; i++) {
							palestrante.setNome(palestrante.getNome() + " " + line[i]);
						}
						palestra.setPalestrante(palestrante);
						break;
					case "Tema:":
						palestra.setTema(line[1]);
						for (int i = 2; i < line.length; i++) {
							palestra.setTema(palestra.getTema() + " " + line[i]);
						}
						break;
					case "Local:":
						palestra.setLocal(line[1]);
						for (int i = 2; i < line.length; i++) {
							palestra.setLocal(palestra.getLocal() + " " + line[i]);
						}
						break;
					case "Duracao:":
						palestra.setDuracao(line[1]);
						for (int i = 2; i < line.length; i++) {
							palestra.setDuracao(palestra.getDuracao() + " " + line[i]);
						}
						palestras.add(palestra);
						palestra = new Palestra();
						break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return palestras;
	}

	@Override
	public List<Palestrante> lerArquivoPalestrantes(String fileName) {
		List<Palestrante> palestrantes = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH + fileName))) {
			Palestrante palestrante = new Palestrante();
			String currentLine;
			while ((currentLine = bufferedReader.readLine()) != null) {
				String[] line = currentLine.trim().replaceAll("\\.", "").split(" ");
				switch (line[0]) {
					case "Nome:":
						palestrante.setNome(line[1]);
						for (int i = 2; i < line.length; i++) {
							palestrante.setNome(palestrante.getNome() + " " + line[i]);
						}
						break;
					case "Disponibilidade:":
						palestrante.setDisponibilidade(line[1]);
						for (int i = 2; i < line.length; i++) {
							palestrante.setDisponibilidade(palestrante.getDisponibilidade() + " " + line[i]);
						}
						palestrantes.add(palestrante);
						palestrante = new Palestrante();
						break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return palestrantes;
	}
	
}
