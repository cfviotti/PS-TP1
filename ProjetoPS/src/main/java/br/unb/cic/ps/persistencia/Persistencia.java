package br.unb.cic.ps.persistencia;

import java.util.List;
import java.util.Map;

import br.unb.cic.ps.entidade.Palestra;

public interface Persistencia {

	String FILE_PATH = "src/main/resources/arquivosTexto/";
	
	boolean persistenciaTest();
	
	void imprimirArquivo(Map<Integer, List<Palestra>> palestras, String fileName, Integer opcao);
	
}
