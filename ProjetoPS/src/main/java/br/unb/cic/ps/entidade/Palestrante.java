package br.unb.cic.ps.entidade;

import java.util.List;

public class Palestrante {

	private String nome;
	
	private List<Disponibilidade> disponibilidades;

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Nome: ");
		stringBuilder.append(nome + "; ");
		stringBuilder.append("Disponibilidade: ");
		for (Disponibilidade disponibilidade : disponibilidades) {
			stringBuilder.append(disponibilidade.getDiaSemana() + ", ");
			stringBuilder.append(disponibilidade.getData() + ", ");
			stringBuilder.append(disponibilidade.getHorario() + "; ");
		}
		return stringBuilder.toString();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disponibilidade> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(List<Disponibilidade> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}
	
}
