package br.unb.cic.ps.controle;

import java.util.List;
import java.util.Map;

import br.unb.cic.ps.entidade.Palestra;

public interface Controle {

	boolean controleTest();
	
	void alocarPalestras(List<Palestra> palestras);
	
	void removerPalestrasSemHorario(List<Palestra> palestras);
	
	Map<Integer, List<Palestra>> gerarMapaPalestras(List<Palestra> palestras);

}
