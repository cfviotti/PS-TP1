package palestrante;

import java.util.ArrayList;
import java.util.List;

import calendario.CalendarioTratamento;
import calendario.CalendarioTratamentoImpl;
import entidade.Disponibilidade;
import entidade.Palestra;
import entidade.Palestrante;

public class PalestranteTratamentoImpl implements PalestranteTratamento {

	CalendarioTratamento calendarioTratamento = new CalendarioTratamentoImpl();
	
	@Override
	public List<Palestrante> tratarDadosPalestrantes(List<String[]> dados) {
		List<Palestrante> palestrantes = new ArrayList<>();
		Palestrante palestrante = new Palestrante();
		for (String[] line : dados) {
			switch (line[0]) {
			case "Nome:":
				palestrante.setNome(line[1]);
				for (int i = 2; i < line.length; i++) {
					palestrante.setNome(palestrante.getNome() + " " + line[i]);
				}
				break;
			case "Disponibilidade:":
				List<Disponibilidade> disponibilidades = new ArrayList<>();
				Disponibilidade disponibilidade = new Disponibilidade();
				String diaSemanaString = line[1];
				String dataString = line[2];
				String horarioString = line[3];
				disponibilidade.setDiaSemana(calendarioTratamento.buscarDiaSemana(diaSemanaString));
				disponibilidade.setDataInicio(calendarioTratamento.buscarDataInicio(dataString, horarioString));
				disponibilidade.setDataFim(calendarioTratamento.buscarDataFim(dataString, horarioString));
				disponibilidade.setDisponivelTodaSemana(calendarioTratamento.isDisponivelTodaSemana(dataString));
				disponibilidades.add(disponibilidade);
				int j = 4;
				int stop = j + 3;
				for (int i = 1; i < line.length / 3; i++) {
					while (j < stop) {
						disponibilidade = new Disponibilidade();
						diaSemanaString = line[j];
						dataString = line[++j];
						horarioString = line[++j];
						disponibilidade.setDiaSemana(calendarioTratamento.buscarDiaSemana(diaSemanaString));
						disponibilidade.setDataInicio(calendarioTratamento.buscarDataInicio(dataString, horarioString));
						disponibilidade.setDataFim(calendarioTratamento.buscarDataFim(dataString, horarioString));
						disponibilidade.setDisponivelTodaSemana(calendarioTratamento.isDisponivelTodaSemana(dataString));
						disponibilidades.add(disponibilidade);
						j++;
					}
					stop = j + 3;
				}
				palestrante.setDisponibilidades(disponibilidades);
				palestrantes.add(palestrante);
				palestrante = new Palestrante();
				break;
			}
		}
		return palestrantes;
	}
	
	@Override
	public void adicionarPalestrantes(List<Palestra> palestras, List<Palestrante> palestrantes) {
		for (Palestra palestra : palestras) {
			for (Palestrante palestrante : palestrantes) {
				if (palestra.getPalestrante() != null && palestra.getPalestrante().getNome() != null) {
					if (palestra.getPalestrante().getNome().equals(palestrante.getNome())) {
						palestra.setPalestrante(palestrante);
						
					}
				}
			}
		}
	}
	
}
