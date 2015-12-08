package palestra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PalestraLeituraImpl implements PalestraLeitura {

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
			System.out.println("Arquivo " + fileName + " não existe. O programa não será iniciado.");
			System.exit(1);
		}
		return dados;
	}

}
