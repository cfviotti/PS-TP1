package br.unb.cic.ps.leitura;

import java.util.List;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;

public interface Leitura {

	String FILE_PATH = "src/main/resources/arquivosTexto/";
	
	boolean leituraTest();
	
	List<Palestra> lerArquivoPalestras(String fileName);
	
	List<Palestrante> lerArquivoPalestrantes(String fileName);
	
}
