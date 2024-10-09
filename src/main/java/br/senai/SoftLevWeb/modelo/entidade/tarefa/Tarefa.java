package br.senai.SoftLevWeb.modelo.entidade.tarefa;

import java.io.Serializable;

import br.senai.SoftLevWeb.modelo.entidade.tipoTarefa.TipoTarefa;

public class Tarefa implements Serializable {

	private static final long serialVersionUID = 5007407356250769572L;

	private Long id;
	private String nome;
	private String desc;
	private TipoTarefa tipoTarefa;

	public Tarefa(Long id, String nome, String desc, TipoTarefa tipoTarefa) {
		this.id = id;
		this.nome = nome;
		this.desc = desc;
		this.tipoTarefa = tipoTarefa;
	}

	public Tarefa(String nome, String desc, TipoTarefa tipoTarefa) {
		this.nome = nome;
		this.desc = desc;
		this.tipoTarefa = tipoTarefa;
	}

	public Tarefa() {
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public TipoTarefa getTipoTarefa() {
		return tipoTarefa;
	}

	public void setTipoTarefa(TipoTarefa tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}
}
