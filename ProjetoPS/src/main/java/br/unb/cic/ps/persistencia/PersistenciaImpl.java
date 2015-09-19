package br.unb.cic.ps.persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import br.unb.cic.ps.entidade.Palestra;

public class PersistenciaImpl implements Persistencia {

	@Override
	public boolean persistenciaTest() {
		return true;
	}

	@Override
	public void imprimirArquivo(Map<Integer, List<Palestra>> palestrasMap, String fileName, Integer opcao) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH + fileName))) {
			if (opcao != 0) {
				bufferedWriter.write("Calendario de Palestras (" + (opcao) + "/2015)\n\n");
				for (Palestra palestra : palestrasMap.get(--opcao)) {
					bufferedWriter.write(palestra.getNome() + " (" + palestra.getPalestrante().getNome() + "): ");
					bufferedWriter.write(formatarHorario(palestra.getDataInicio().get(Calendar.HOUR_OF_DAY)) + ":");
					bufferedWriter.write(formatarHorario(palestra.getDataInicio().get(Calendar.MINUTE)) + "-");
					bufferedWriter.write(formatarHorario(palestra.getDataFim().get(Calendar.HOUR_OF_DAY)) + ":");
					bufferedWriter.write(formatarHorario(palestra.getDataFim().get(Calendar.MINUTE)) + ".\n");
				}
				bufferedWriter.write("\n");
			} else {
				for (Map.Entry<Integer, List<Palestra>> entry : palestrasMap.entrySet()) {
					bufferedWriter.write("Calendario de Palestras (" + (entry.getKey() + 1) + "/2015)\n\n");
					for (Palestra palestra : entry.getValue()) {
						bufferedWriter.write(palestra.getNome() + " (" + palestra.getPalestrante().getNome() + "): ");
						bufferedWriter.write(formatarHorario(palestra.getDataInicio().get(Calendar.HOUR_OF_DAY)) + ":");
						bufferedWriter.write(formatarHorario(palestra.getDataInicio().get(Calendar.MINUTE)) + "-");
						bufferedWriter.write(formatarHorario(palestra.getDataFim().get(Calendar.HOUR_OF_DAY)) + ":");
						bufferedWriter.write(formatarHorario(palestra.getDataFim().get(Calendar.MINUTE)) + ".\n");
					}
					bufferedWriter.write("\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String formatarHorario(int horario) {
		return (String) (horario < 10 ? ("0" + horario) : String.valueOf(horario));
	}

}
