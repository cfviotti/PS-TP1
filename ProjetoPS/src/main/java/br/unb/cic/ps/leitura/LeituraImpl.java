package br.unb.cic.ps.leitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraImpl implements Leitura {

	@Override
	public boolean leituraTest() {
		return true;
	}

	@Override
	public List<String[]> lerArquivoPalestras(String fileName) {
		List<String[]> dados = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH + fileName))) {
			String currentLine;
			while ((currentLine = bufferedReader.readLine()) != null) {
				String[] line = currentLine.trim().replaceAll("\\.", "").split(" ");
				dados.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dados;
	}

	@Override
	public List<String[]> lerArquivoPalestrantes(String fileName) {
		List<String[]> dados = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH + fileName))) {
			String currentLine;
			while ((currentLine = bufferedReader.readLine()) != null) {
				String[] line = currentLine.trim().replaceAll("\\.", "").
						replaceAll(",", "").replaceAll(";", "").split(" ");
				dados.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dados;
	}
	
}
