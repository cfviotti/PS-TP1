package br.unb.cic.ps.entidade;

public class Palestra {

	private String nome;
	
	private Palestrante palestrante;
	
	private String tema;
	
	private String local;
	
	private Integer duracao;

	@Override
	public String toString() {
		return "Nome: " + nome + ", Nome do Palestrante: " + palestrante.getNome() +
				", Tema: " + tema +	", Local: " + local + ", Duracao: " + duracao + " minutos";
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
	
}
