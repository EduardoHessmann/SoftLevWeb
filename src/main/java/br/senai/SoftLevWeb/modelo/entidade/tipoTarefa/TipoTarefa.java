package br.senai.SoftLevWeb.modelo.entidade.tipoTarefa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tipo_tarefa")
public class TipoTarefa implements Serializable {

	private static final long serialVersionUID = 6824595573074203391L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_tarefa")
	private Long id;
	
	@Column(name = "nome", length = 100, nullable = false)
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
