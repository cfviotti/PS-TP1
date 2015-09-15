package br.unb.cic.ps.tratamento;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.ps.entidade.Disponibilidade;
import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;

public class TratamentoImpl implements Tratamento {

	@Override
	public boolean tratamentoTest() {
		return true;
	}

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
				palestra.setDuracao(line[1]);
				for (int i = 2; i < line.length; i++) {
					palestra.setDuracao(palestra.getDuracao() + " " + line[i]);
				}
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
				disponibilidade.setDiaSemana(line[1]);
				disponibilidade.setData(line[2]);
				disponibilidade.setHorario(line[3]);
				disponibilidades.add(disponibilidade);
				int j = 4;
				int stop = j + 3;
				for (int i = 1; i < line.length / 3; i++) {
					while (j < stop) {
						disponibilidade = new Disponibilidade();
						disponibilidade.setDiaSemana(line[j]);
						disponibilidade.setData(line[++j]);
						disponibilidade.setHorario(line[++j]);
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
	
}
