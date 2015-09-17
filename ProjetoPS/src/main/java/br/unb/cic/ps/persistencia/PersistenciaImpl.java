package br.unb.cic.ps.persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import br.unb.cic.ps.entidade.Disponibilidade;
import br.unb.cic.ps.entidade.Palestra;

public class PersistenciaImpl implements Persistencia {

	@Override
	public boolean persistenciaTest() {
		return true;
	}

	@Override
	public void imprimirArquivo(List<Palestra> palestras, String fileName) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH + fileName))) {
			for (Palestra palestra : palestras) {
				bufferedWriter.write(palestra.getNome() + " (" + palestra.getPalestrante().getNome() + "): ");
				for (Disponibilidade disponibilidade : palestra.getPalestrante().getDisponibilidades()) {
					Integer horas = disponibilidade.getDataFim().get(Calendar.HOUR_OF_DAY) - disponibilidade.getDataInicio().get(Calendar.HOUR_OF_DAY);
					Integer minutos = disponibilidade.getDataFim().get(Calendar.MINUTE) - disponibilidade.getDataInicio().get(Calendar.MINUTE);
					Integer minutosDisponiveis = horas * 60 + minutos;
					if (minutosDisponiveis >= palestra.getDuracao()) {
						bufferedWriter.write(disponibilidade.getDataInicio().get(Calendar.HOUR_OF_DAY) + ":");
						bufferedWriter.write(disponibilidade.getDataInicio().get(Calendar.MINUTE) + "-");
						bufferedWriter.write(disponibilidade.getDataFim().get(Calendar.HOUR_OF_DAY) + ":");
						bufferedWriter.write(disponibilidade.getDataFim().get(Calendar.MINUTE) + ". ");
						bufferedWriter.write("\n");
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
