package calendario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import entidade.Palestra;

public class CalendarioPersistenciaImpl implements CalendarioPersistencia {

	@Override
	public String imprimirArquivo(Map<Integer, List<Palestra>> palestrasMap, String fileName, Integer opcao) {
		File file = new File(FILE_PATH + fileName);
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
			if (opcao != 0) {
				Palestra primeiraPalestra = palestrasMap.get(opcao - 1).get(0);
				bufferedWriter.write("Calendario de Palestras (" + (opcao) + "/" +
				primeiraPalestra.getDataInicio().get(Calendar.YEAR) + ")\n\n");
				Integer dataAnterior = 0;
				for (Palestra palestra : palestrasMap.get(opcao - 1)) {
					Integer dataAtual = palestra.getDataInicio().get(Calendar.DAY_OF_MONTH);
					if (!dataAtual.equals(dataAnterior)) {
						dataAnterior = dataAtual;
						bufferedWriter.write("Dia " + dataAtual + "\n");
					}
					bufferedWriter.write(palestra.getNome() + " (" + palestra.getPalestrante().getNome() + "): ");
					bufferedWriter.write(formatarHorario(palestra.getDataInicio().get(Calendar.HOUR_OF_DAY)) + ":");
					bufferedWriter.write(formatarHorario(palestra.getDataInicio().get(Calendar.MINUTE)) + "-");
					bufferedWriter.write(formatarHorario(palestra.getDataFim().get(Calendar.HOUR_OF_DAY)) + ":");
					bufferedWriter.write(formatarHorario(palestra.getDataFim().get(Calendar.MINUTE)) + ".\n");
				}
				bufferedWriter.write("\n");
			} else {
				boolean escreverCalendario = true;
				for (Map.Entry<Integer, List<Palestra>> entry : palestrasMap.entrySet()) {
					if (entry.getValue().get(0) == null) {
						continue;
					}
					Palestra primeiraPalestra = entry.getValue().get(0);
					if (escreverCalendario) {
						bufferedWriter.write("Calendario de Palestras (1-12/ " +
								primeiraPalestra.getDataInicio().get(Calendar.YEAR) + ")\n\n");
						escreverCalendario = false;
					}
					bufferedWriter.write("Mês " + (primeiraPalestra.getDataInicio().get(Calendar.MONTH) + 1) +
							"/" + primeiraPalestra.getDataInicio().get(Calendar.YEAR) + "\n");
					Integer dataAnterior = 0;
					
					for (Palestra palestra : entry.getValue()) {
						Integer dataAtual = palestra.getDataInicio().get(Calendar.DAY_OF_MONTH);
						if (!dataAtual.equals(dataAnterior)) {
							bufferedWriter.write("Dia " + dataAtual + "\n");
							dataAnterior = dataAtual;
						}
						bufferedWriter.write(palestra.getNome() + " (" + palestra.getPalestrante().getNome() + "): ");
						bufferedWriter.write(formatarHorario(palestra.getDataInicio().get(Calendar.HOUR_OF_DAY)) + ":");
						bufferedWriter.write(formatarHorario(palestra.getDataInicio().get(Calendar.MINUTE)) + "-");
						bufferedWriter.write(formatarHorario(palestra.getDataFim().get(Calendar.HOUR_OF_DAY)) + ":");
						bufferedWriter.write(formatarHorario(palestra.getDataFim().get(Calendar.MINUTE)) + ".\n");
						bufferedWriter.write("Local: " + palestra.getLocal().getNome() + ".\n");
						bufferedWriter.write("Endereço: " + palestra.getLocal().getEndereco() + ".\n");
					}
					bufferedWriter.write("\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file.getAbsolutePath();
	}
	
	private String formatarHorario(int horario) {
		return (String) (horario < 10 ? ("0" + horario) : String.valueOf(horario));
	}
	
}
