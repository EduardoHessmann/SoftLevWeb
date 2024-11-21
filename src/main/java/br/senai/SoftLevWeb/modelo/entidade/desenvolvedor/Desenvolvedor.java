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

/**
 * Classe que representa a entidade Desenvolvedor no banco de dados.
 * Esta classe utiliza a estratégia de herança JOINED no JPA para permitir a herança de subclasses.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "desenvolvedor")
public class Desenvolvedor implements Serializable {

    // Serial version UID para garantir a compatibilidade durante a serialização
    private static final long serialVersionUID = 2482014914550908553L;

    // Atributo de ID da entidade, gerado automaticamente pelo banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desenvolvedor")
    private Long id;

    // Atributo que armazena o nome do desenvolvedor
    @Column(name = "nome_desenvolvedor", length = 25, nullable = false)
    private String nome;

    // Atributo que armazena o email do desenvolvedor
    @Column(name = "email_deselvolvedor", length = 65, nullable = false)
    private String email;

    // Atributo que armazena o nível do desenvolvedor, representado por um código de 3 caracteres
    @Column(name = "nivel_desenvolvedor", length = 3, columnDefinition = "CHAR(3)", nullable = false)
    private String nivel;

    // Atributo que armazena a senha do desenvolvedor
    @Column(name = "senha_desenvolvedor", length = 25, nullable = false)
    private String senha;

    /**
     * Construtor padrão da classe, necessário para o JPA.
     */
    public Desenvolvedor() {}

    /**
     * Construtor que inicializa todos os campos obrigatórios da entidade.
     * 
     * @param nome O nome do desenvolvedor.
     * @param email O email do desenvolvedor.
     * @param nivel O nível do desenvolvedor.
     * @param senha A senha do desenvolvedor.
     */
    public Desenvolvedor(String nome, String email, String nivel, String senha) {
        this.nome = nome;
        this.email = email;
        this.nivel = nivel;
        this.senha = senha;
    }

    /**
     * Construtor que inicializa todos os campos da entidade, incluindo o ID.
     * 
     * @param id O ID do desenvolvedor.
     * @param nome O nome do desenvolvedor.
     * @param email O email do desenvolvedor.
     * @param nivel O nível do desenvolvedor.
     * @param senha A senha do desenvolvedor.
     */
    public Desenvolvedor(Long id, String nome, String email, String nivel, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.nivel = nivel;
        this.senha = senha;
    }

    /**
     * Obtém o ID do desenvolvedor.
     * 
     * @return O ID do desenvolvedor.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do desenvolvedor.
     * 
     * @param id O ID do desenvolvedor.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do desenvolvedor.
     * 
     * @return O nome do desenvolvedor.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do desenvolvedor.
     * 
     * @param nome O nome do desenvolvedor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o email do desenvolvedor.
     * 
     * @return O email do desenvolvedor.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do desenvolvedor.
     * 
     * @param email O email do desenvolvedor.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o nível do desenvolvedor.
     * 
     * @return O nível do desenvolvedor.
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * Define o nível do desenvolvedor.
     * 
     * @param nivel O nível do desenvolvedor.
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * Obtém a senha do desenvolvedor.
     * 
     * @return A senha do desenvolvedor.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do desenvolvedor.
     * 
     * @param senha A senha do desenvolvedor.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
