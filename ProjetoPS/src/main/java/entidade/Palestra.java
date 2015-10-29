package entidade;

import java.util.Calendar;

/**
 * A Classe Palestra.
 */
public class Palestra implements Comparable<Palestra> {

	private String nome;
	
	private Palestrante palestrante;
	
	private String tema;
	
	private Localidade local;
	
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
	
	/**
	 * Retorna uma instância de nome.
	 * 
	 * @return uma instância de nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Atualizar uma instância de nome.
	 * 
	 * @param nome, o nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna uma instância de palestrante.
	 * 
	 * @return uma instância de palestrante
	 */
	public Palestrante getPalestrante() {
		return palestrante;
	}

	/**
	 * Atualizar uma instância de palestrante.
	 * 
	 * @param palestrante, o palestrante
	 */
	public void setPalestrante(Palestrante palestrante) {
		this.palestrante = palestrante;
	}

	/**
	 * Retorna uma instância de tema.
	 * 
	 * @return uma instância de tema
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * Atualizar uma instância de tema.
	 * 
	 * @param tema, o tema
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * Retorna uma instância de local.
	 * 
	 * @return uma instância de local
	 */
	public Localidade getLocal() {
		return local;
	}

	/**
	 * Atualizar uma instância de local.
	 * 
	 * @param local, o local
	 */
	public void setLocal(Localidade local) {
		this.local = local;
	}

	/**
	 * Retorna uma instância de duracao.
	 * 
	 * @return uma instância de duracao
	 */
	public Integer getDuracao() {
		return duracao;
	}

	/**
	 * Atualizar uma instância de duracao.
	 * 
	 * @param duracao, o duracao
	 */
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	/**
	 * Retorna uma instância de dataInicio.
	 * 
	 * @return uma instância de dataInicio
	 */
	public Calendar getDataInicio() {
		return dataInicio;
	}

	/**
	 * Atualizar uma instância de dataInicio.
	 * 
	 * @param dataInicio, o dataInicio
	 */
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * Retorna uma instância de dataFim.
	 * 
	 * @return uma instância de dataFim
	 */
	public Calendar getDataFim() {
		return dataFim;
	}

	/**
	 * Atualizar uma instância de dataFim.
	 * 
	 * @param dataFim, o dataFim
	 */
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

}