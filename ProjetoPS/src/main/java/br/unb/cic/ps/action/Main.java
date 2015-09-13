package br.unb.cic.ps.action;

import java.util.List;

import br.unb.cic.ps.entidade.Palestra;
import br.unb.cic.ps.entidade.Palestrante;
import br.unb.cic.ps.leitura.Leitura;
import br.unb.cic.ps.leitura.LeituraImpl;

public class Main {

	public static void main(String[] args) {
		Leitura moduloLeitura = new LeituraImpl();
		System.out.println("Palestras:");
		List<Palestra> palestras = moduloLeitura.lerArquivoPalestras("Palestras.txt");
		for (Palestra palestra : palestras) {
			System.out.println(palestra);
		}
		System.out.println("Palestrantes:");
		List<Palestrante> palestrantes = moduloLeitura.lerArquivoPalestrantes("Palestrantes.txt");
		for (Palestrante palestrante : palestrantes) {
			System.out.println(palestrante);
		}
	}
	
}
