package br.unb.cic.ps.entidade;

import java.util.Calendar;

public class Palestra implements Comparable<Palestra> {

	private String nome;
	
	private Palestrante palestrante;
	
	private String tema;
	
	private String local;
	
	private Integer duracao;
	
	private Calendar dataInicio;
	
	private Calendar dataFim;

	@Override
	public String toString() {
		return "Nome: " + nome +
				", Nome do Palestrante: " + palestrante.getNome() +
				", Tema: " + tema +
				", Local: " + local +
				", Duracao: " + duracao + " minutos" +
				", Data: "  + (dataInicio != null ? dataInicio.getTime() : "Sem horario.");
	}
	
	@Override
	public int compareTo(Palestra palestra) {
		if (dataInicio.before(palestra.getDataInicio())) {
			return -1;
		} else if (dataInicio.after(palestra.getDataInicio())) {
			return 1;
		}
		return 0;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Palestrante getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

}
