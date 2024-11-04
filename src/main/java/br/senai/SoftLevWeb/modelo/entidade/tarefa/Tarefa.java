package br.senai.SoftLevWeb.modelo.entidade.tarefa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.senai.SoftLevWeb.modelo.entidade.desenvolvedor.Desenvolvedor;
import br.senai.SoftLevWeb.modelo.entidade.tipoTarefa.TipoTarefa;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tarefa")
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 5007407356250769572L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarefa")
	private Long id;

	@Column(name = "nome_tarefa", length = 30, nullable = false)
	private String nome;

	@Column(name = "desc_tarefa", length = 60, nullable = false)
	private String desc;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_tarefa", referencedColumnName = "id_tipo_tarefa")
	private TipoTarefa tipoTarefa;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_desenvolvedor", referencedColumnName = "id_desenvolvedor")
	private Desenvolvedor desenvolvedor;

	public Tarefa(Long id, String nome, String desc, TipoTarefa tipoTarefa, Desenvolvedor desenvolvedor) {
		this.id = id;
		this.nome = nome;
		this.desc = desc;
		this.tipoTarefa = tipoTarefa;
		this.desenvolvedor = desenvolvedor;
	}

	public Tarefa(String nome, String desc, TipoTarefa tipoTarefa, Desenvolvedor desenvolvedor) {
		this.nome = nome;
		this.desc = desc;
		this.tipoTarefa = tipoTarefa;
		this.desenvolvedor = desenvolvedor;
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

	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

}
