package br.unb.cic.ps.entidade;

public class Palestra {

	private String nome;
	
	private Palestrante palestrante;
	
	private String tema;
	
	private String local;
	
	private String duracao;

	@Override
	public String toString() {
		return "Nome: " + nome + ", Nome do Palestrante: " + palestrante.getNome() +
				", Tema: " + tema +	", Local: " + local + ", Duracao: " + duracao;
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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
}
