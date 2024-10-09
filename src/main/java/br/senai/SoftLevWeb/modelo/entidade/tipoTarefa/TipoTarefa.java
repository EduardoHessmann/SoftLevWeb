package br.senai.SoftLevWeb.modelo.entidade.tipoTarefa;

import java.io.Serializable;

public class TipoTarefa implements Serializable {

	private static final long serialVersionUID = 6824595573074203391L;

	private Long id;
	private String nome;

	public TipoTarefa() {}

	public TipoTarefa(String nome) {
		this.nome = nome;
	}

	public TipoTarefa(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
