package localidade;

import java.util.ArrayList;
import java.util.List;

import calendario.CalendarioTratamento;
import calendario.CalendarioTratamentoImpl;
import entidade.Disponibilidade;
import entidade.Localidade;

public class LocalidadeTratamentoImpl implements LocalidadeTratamento {

CalendarioTratamento calendarioTratamento = new CalendarioTratamentoImpl();
	
	@Override
	public List<Localidade> tratarDadosLocalidades(List<String[]> dados) {
		List<Localidade> localidades = new ArrayList<>();
		Localidade localidade = new Localidade();
		for (String[] line : dados) {
			switch (line[0]) {
			case "Nome:":
				localidade.setNome(line[1]);
				for (int i = 2; i < line.length; i++) {
					localidade.setNome(localidade.getNome() + " " + line[i]);
				}
				break;
			case "Endereco:":
				localidade.setEndereco(line[1]);
				for (int i = 2; i < line.length; i++) {
					localidade.setEndereco(localidade.getEndereco() + " " + line[i]);
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
				localidade.setDisponibilidades(disponibilidades);
				localidades.add(localidade);
				localidade = new Localidade();
				break;
			}
		}
		return localidades;
	}

}
