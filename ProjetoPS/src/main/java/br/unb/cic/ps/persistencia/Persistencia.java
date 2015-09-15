package br.unb.cic.ps.persistencia;

import java.util.List;

import br.unb.cic.ps.entidade.Palestra;

public interface Persistencia {

	String FILE_PATH = "src/main/resources/arquivosTexto/";
	
	boolean persistenciaTest();
	
	void imprimirArquivo(List<Palestra> palestras, String fileName);
	
}
