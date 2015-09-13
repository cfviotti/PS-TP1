package br.unb.cic.ps.tratamento;

import java.util.List;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;

public interface Tratamento {

	boolean tratamentoTest();
	
	List<Palestra> tratarDadosPalestras(List<String[]> dados);
	
	List<Palestrante> tratarDadosPalestrantes(List<String[]> dados);
	
}
