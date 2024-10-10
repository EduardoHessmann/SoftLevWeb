package br.senai.SoftLevWeb.modelo.entidade.desenvolvedor;

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
@Table(name = "desenvolvedor")
public class Desenvolvedor implements Serializable {

	private static final long serialVersionUID = 2482014914550908553L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_desenvolvedor")
	private Long id;

	@Column(name = "nome_desenvolvedor", length = 25, nullable = false)
	private String nome;

	@Column(name = "email_deselvolvedor", length = 65, nullable = false)
	private String email;

	@Column(name = "senha_desenvolvedor", length = 25, nullable = false)
	private String senha;
	
	public Desenvolvedor() {};

	public Desenvolvedor(Long id, String nome, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Desenvolvedor(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
