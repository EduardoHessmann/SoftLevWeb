package br.senai.SoftLevWeb.modelo.entidade.usuario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Classe que representa um usuário no sistema.
 * A classe utiliza a estratégia de herança JOINED no JPA, permitindo a herança de subclasses.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario implements Serializable {

    // Serial version UID para garantir a compatibilidade durante a serialização
    private static final long serialVersionUID = 8812649284236887370L;
    
    // Atributo de ID da entidade, gerado automaticamente pelo banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    
    // Atributo que armazena o nome do usuário
    @Column(name = "nome_usuario", length = 25, nullable = false)
    private String nome;
    
    // Atributo que armazena o email do usuário
    @Column(name = "email_usuario", length = 65, nullable = false)
    private String email;
    
    // Atributo que armazena o nível do usuário, com um comprimento fixo de 3 caracteres
    @Column(name = "nivel_usuario", length = 3, columnDefinition = "CHAR(3)", nullable = false)
    private String nivel;
    
    // Atributo que armazena a senha do usuário
    @Column(name = "senha_usuario", length = 25, nullable = false)
    private String senha;
    
    /**
     * Construtor padrão da classe, necessário para o JPA.
     */
    public Usuario() {}

    /**
     * Construtor que inicializa os campos nome, email, nível e senha do usuário.
     * 
     * @param nome O nome do usuário.
     * @param email O email do usuário.
     * @param nivel O nível do usuário.
     * @param senha A senha do usuário.
     */
    public Usuario(String nome, String email, String nivel, String senha) {
        this.nome = nome;
        this.email = email;
        this.nivel = nivel;
        this.senha = senha;
    }
    
    /**
     * Construtor que inicializa todos os campos da entidade.
     * 
     * @param id O ID do usuário.
     * @param nome O nome do usuário.
     * @param email O email do usuário.
     * @param nivel O nível do usuário.
     * @param senha A senha do usuário.
     */
    public Usuario(Long id, String nome, String email, String nivel, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nivel = nivel;
        this.senha = senha;
    }
    
    /**
     * Obtém o ID do usuário.
     * 
     * @return O ID do usuário.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Define o ID do usuário.
     * 
     * @param id O ID do usuário.
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Obtém o nome do usuário.
     * 
     * @return O nome do usuário.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o nome do usuário.
     * 
     * @param nome O nome do usuário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtém o email do usuário.
     * 
     * @return O email do usuário.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Define o email do usuário.
     * 
     * @param email O email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Obtém o nível do usuário.
     * 
     * @return O nível do usuário.
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Define o nível do usuário.
     * 
     * @param nivel O nível do usuário.
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtém a senha do usuário.
     * 
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Define a senha do usuário.
     * 
     * @param senha A senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
