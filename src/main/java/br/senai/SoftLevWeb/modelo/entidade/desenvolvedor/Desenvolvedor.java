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
	
	@Column(name = "nivel_desenvolvedor", length = 3, columnDefinition = "CHAR(3)", nullable = false)
	private String nivel;
	
	@Column(name = "senha_usuario", length = 25, nullable = false)
	private String senha;
	
	public Desenvolvedor() {}
	
	public Desenvolvedor(String nome, String email, String nivel, String senha) {
		this.nome = nome;
		this.email = email;
		this.nivel = nivel;
		this.senha = senha;
	}
	
	public Desenvolvedor(Long id, String nome, String email, String nivel, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.nivel = nivel;
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

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
