package br.unb.cic.ps.tratamento;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.ps.calendario.Calendario;
import br.unb.cic.ps.calendario.CalendarioImpl;
import br.unb.cic.ps.entidade.Disponibilidade;
import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;

public class TratamentoImpl implements Tratamento {

	Calendario moduloCalendario = new CalendarioImpl();

	@Override
	public List<Palestra> tratarDadosPalestras(List<String[]> dados) {
		List<Palestra> palestras = new ArrayList<>();
		Palestra palestra = new Palestra();
		for (String[] line : dados) {
			switch (line[0]) {
			case "Nome:":
				palestra.setNome(line[1]);
				for (int i = 2; i < line.length; i++) {
					palestra.setNome(palestra.getNome() + " " + line[i]);
				}
				break;
			case "Palestrante:":
				Palestrante palestrante = new Palestrante();
				palestrante.setNome(line[1]);
				for (int i = 2; i < line.length; i++) {
					palestrante.setNome(palestrante.getNome() + " " + line[i]);
				}
				palestra.setPalestrante(palestrante);
				break;
			case "Tema:":
				palestra.setTema(line[1]);
				for (int i = 2; i < line.length; i++) {
					palestra.setTema(palestra.getTema() + " " + line[i]);
				}
				break;
			case "Local:":
				palestra.setLocal(line[1]);
				for (int i = 2; i < line.length; i++) {
					palestra.setLocal(palestra.getLocal() + " " + line[i]);
				}
				break;
			case "Duracao:":
				String[] duracao = line[1].replaceAll("h", "").replaceAll("H", "").split(":");
				Integer minutos = Integer.valueOf(duracao[0]) * 60 + Integer.valueOf(duracao[1]);
				palestra.setDuracao(minutos);
				palestras.add(palestra);
				palestra = new Palestra();
				break;
			}
		}
		return palestras;
	}

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
				disponibilidade.setDiaSemana(moduloCalendario.buscarDiaSemana(diaSemanaString));
				disponibilidade.setDataInicio(moduloCalendario.buscarDataInicio(dataString, horarioString));
				disponibilidade.setDataFim(moduloCalendario.buscarDataFim(dataString, horarioString));
				disponibilidade.setDisponivelTodaSemana(moduloCalendario.isDisponivelTodaSemana(dataString));
				disponibilidades.add(disponibilidade);
				int j = 4;
				int stop = j + 3;
				for (int i = 1; i < line.length / 3; i++) {
					while (j < stop) {
						disponibilidade = new Disponibilidade();
						diaSemanaString = line[j];
						dataString = line[++j];
						horarioString = line[++j];
						disponibilidade.setDiaSemana(moduloCalendario.buscarDiaSemana(diaSemanaString));
						disponibilidade.setDataInicio(moduloCalendario.buscarDataInicio(dataString, horarioString));
						disponibilidade.setDataFim(moduloCalendario.buscarDataFim(dataString, horarioString));
						disponibilidade.setDisponivelTodaSemana(moduloCalendario.isDisponivelTodaSemana(dataString));
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
