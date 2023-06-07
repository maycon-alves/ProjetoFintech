package br.com.projetoFintech.model;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
	/**
	 * esta classe e um javabean
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * codigo de documento utilizado como identificador unico para cada pessoa
	 */
	private String cpf;
	/**
	 * nome utilizado para se referir a uma pessoa de forma amigavel
	 */
	private String nome;

	public Pessoa() {

	}

	public Pessoa(String cpf, String nome) {
		this.setCpf(cpf);
		this.setNome(nome);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "cpf=" + cpf + ", nome=" + nome;
	}

}
