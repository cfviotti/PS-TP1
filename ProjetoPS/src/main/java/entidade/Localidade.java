package entidade;

import java.util.List;

/**
 * A Classe Localidade
 */
public class Localidade {

	private String nome;
	
	private String endereco;
	
	private List<Disponibilidade> disponibilidades;

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Nome: ");
		stringBuilder.append(nome + "; ");
		stringBuilder.append("Disponibilidade: ");
		for (Disponibilidade disponibilidade : disponibilidades) {
			stringBuilder.append(disponibilidade.toString());
		}
		return stringBuilder.toString();
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
	 * Retorna uma instância de endereco.
	 * 
	 * @return uma instância de endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Atualizar uma instância de endereco.
	 * 
	 * @param endereco, o endereco
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Retorna uma instância de disponibilidades.
	 * 
	 * @return uma instância de disponibilidades
	 */
	public List<Disponibilidade> getDisponibilidades() {
		return disponibilidades;
	}

	/**
	 * Atualizar uma instância de disponibilidades.
	 * 
	 * @param disponibilidades, o disponibilidades
	 */
	public void setDisponibilidades(List<Disponibilidade> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}
	
}
