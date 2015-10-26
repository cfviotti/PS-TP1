package palestra;

import java.util.ArrayList;
import java.util.List;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;

public class PalestraTratamentoImpl implements PalestraTratamento {

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

}
