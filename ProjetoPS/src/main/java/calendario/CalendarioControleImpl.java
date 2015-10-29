package calendario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import entidade.Disponibilidade;
import entidade.Palestra;

public class CalendarioControleImpl implements CalendarioControle {

	@Override
	public void alocarPalestras(List<Palestra> palestras) {
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
	
}
