package palestra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PalestraLeituraImpl implements PalestraLeitura {

	@Override
	public List<String[]> lerArquivoPalestras(String fileName) {
		List<String[]> dados = new ArrayList<>();
		
		String regexValidadora = "[\"!@#$%&*()\\|^{}]";
		Pattern pattern = Pattern.compile(regexValidadora);	
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH + fileName));
				BufferedWriter Log = new BufferedWriter(new FileWriter(FILE_PATH + "log_erros_palestras.txt"))) {
			String currentLine;
			Integer numLinha = 0;
			while ((currentLine = bufferedReader.readLine()) != null) {
				
				numLinha++;							
				Matcher matcher = pattern.matcher(currentLine);				
				
				if(matcher.find()) {
										
					Log.write(currentLine);
					Log.newLine();								
					
					String strErro = "Foi encontrado um caractere inválido na linha " + numLinha +
							" do arquivo " + fileName + " a linha será gravada em log_erros_palestras.txt e o programa continuará normalmente.";
					
					System.out.println(strErro);					
					
				}
				
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
