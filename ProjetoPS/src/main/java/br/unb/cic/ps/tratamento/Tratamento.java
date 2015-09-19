package br.unb.cic.ps.tratamento;

import java.util.List;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;

public interface Tratamento {

	List<Palestra> tratarDadosPalestras(List<String[]> dados);
	
	List<Palestrante> tratarDadosPalestrantes(List<String[]> dados);
	
	void adicionarPalestrantes(List<Palestra> palestras, List<Palestrante> palestrantes);
	
}
