package br.unb.cic.ps.leitura;

import java.util.List;

public interface Leitura {

	String FILE_PATH = "src/main/resources/arquivosTexto/";
	
	List<String[]> lerArquivoPalestras(String fileName);
	
	List<String[]> lerArquivoPalestrantes(String fileName);
	
}
