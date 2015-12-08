package calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entidade.Disponibilidade;
import entidade.Localidade;
import entidade.Palestra;

public class CalendarioControleImpl implements CalendarioControle {

	@Override
	public void alocarPalestras(List<Palestra> palestras) {
		
		
		try {
			for (Palestra palestra : palestras) {
				for (Disponibilidade disponibilidade : palestra.getPalestrante().getDisponibilidades()) {
					Integer horas = disponibilidade.getDataFim().get(Calendar.HOUR_OF_DAY) - disponibilidade.getDataInicio().get(Calendar.HOUR_OF_DAY);
					Integer minutos = disponibilidade.getDataFim().get(Calendar.MINUTE) - disponibilidade.getDataInicio().get(Calendar.MINUTE);
					Integer minutosDisponiveis = horas * 60 + minutos;
					if (minutosDisponiveis >= palestra.getDuracao()) {
						palestra.setDataInicio(disponibilidade.getDataInicio());
						palestra.setDataFim(disponibilidade.getDataFim());
						break;
					}
				}
			}
		} catch (NullPointerException e) {			
			System.out.println("O arquivo palestrantes.txt está vazio. O programa não será iniciado.");
			System.exit(1);
		}
	}

	@Override
	public void removerPalestrasSemHorario(List<Palestra> palestras) {
		List<Palestra> palestrasRemovidas = new ArrayList<>();
		for (Palestra palestra : palestras) {
			if (palestra.getDataInicio() == null) {
				palestrasRemovidas.add(palestra);
			}
		}
		palestras.removeAll(palestrasRemovidas);
	}

	@Override
	public Map<Integer, List<Palestra>> gerarMapaPalestras(List<Palestra> palestras) {
		Map<Integer, List<Palestra>> palestrasMap = new TreeMap<>();
		for (Palestra palestra : palestras) {
			Integer month = palestra.getDataInicio().get(Calendar.MONTH);
			if (palestrasMap.get(month) != null) {
				List<Palestra> palestraEntry = palestrasMap.get(month);
				palestraEntry.add(palestra);
				palestrasMap.put(month, palestraEntry);
			} else {
				List<Palestra> palestrasEntry = new ArrayList<>();
				palestrasEntry.add(palestra);
				palestrasMap.put(month, palestrasEntry);
			}
		}
		return palestrasMap;
	}
	
	@Override
	public void alocarLocalidades(List<Localidade> localidades, List<Palestra> palestras) {
		for (Palestra palestra : palestras) {
			loopLocal: for (Localidade localidade : localidades) {
				for (Disponibilidade disponibilidadeLocal : localidade.getDisponibilidades()) {
					for (Disponibilidade disponibilidadePalestrante : palestra.getPalestrante().getDisponibilidades()) {
						if (isDisponibilidadeCompativel(disponibilidadePalestrante, disponibilidadeLocal)) {
							palestra.setLocal(localidade);
							break loopLocal;
						}
					}
				}
			}
		}
	}
	
	private boolean isDisponibilidadeCompativel(Disponibilidade disponibilidadePalestrante, Disponibilidade disponibilidadeLocal) {
		if (disponibilidadePalestrante.isDisponivelTodaSemana() || disponibilidadeLocal.isDisponivelTodaSemana()) {
			return disponibilidadePalestrante.getDataInicio().get(Calendar.MONTH) == disponibilidadeLocal.getDataInicio().get(Calendar.MONTH)
					&& disponibilidadePalestrante.getDataInicio().get(Calendar.YEAR) == disponibilidadeLocal.getDataInicio().get(Calendar.YEAR);
		}
		return disponibilidadePalestrante.getDataInicio().get(Calendar.DAY_OF_MONTH) == disponibilidadeLocal.getDataInicio().get(Calendar.DAY_OF_MONTH)
				&& disponibilidadePalestrante.getDataInicio().get(Calendar.MONTH) == disponibilidadeLocal.getDataInicio().get(Calendar.MONTH)
				&& disponibilidadePalestrante.getDataInicio().get(Calendar.YEAR) == disponibilidadeLocal.getDataInicio().get(Calendar.YEAR);
	
	}
	
}
