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

/**
 * Classe que representa o tipo de tarefa no banco de dados.
 * A classe utiliza a estratégia de herança JOINED no JPA, permitindo a herança de subclasses.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tipo_tarefa")
public class TipoTarefa implements Serializable {

    // Serial version UID para garantir a compatibilidade durante a serialização
    private static final long serialVersionUID = 6824595573074203391L;

    // Atributo de ID da entidade, gerado automaticamente pelo banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_tarefa")
    private Long id;

    // Atributo que armazena o nome do tipo de tarefa
    @Column(name = "nome_tipo_tarefa", length = 100, nullable = false)
    private String nome;

    // Atributo que armazena a descrição do tipo de tarefa
    @Column(name = "desc_tipo_tarefa", length = 100, nullable = false)
    private String desc;

    /**
     * Construtor padrão da classe, necessário para o JPA.
     */
    public TipoTarefa() {
    }

    /**
     * Construtor que inicializa os campos nome e descrição do tipo de tarefa.
     * 
     * @param nome O nome do tipo de tarefa.
     * @param desc A descrição do tipo de tarefa.
     */
    public TipoTarefa(String nome, String desc) {
        this.nome = nome;
        this.desc = desc;
    }

    /**
     * Construtor que inicializa todos os campos da entidade.
     * 
     * @param id O ID do tipo de tarefa.
     * @param nome O nome do tipo de tarefa.
     * @param desc A descrição do tipo de tarefa.
     */
    public TipoTarefa(Long id, String nome, String desc) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
    }

    /**
     * Obtém o ID do tipo de tarefa.
     * 
     * @return O ID do tipo de tarefa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do tipo de tarefa.
     * 
     * @param id O ID do tipo de tarefa.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do tipo de tarefa.
     * 
     * @return O nome do tipo de tarefa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do tipo de tarefa.
     * 
     * @param nome O nome do tipo de tarefa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a descrição do tipo de tarefa.
     * 
     * @return A descrição do tipo de tarefa.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Define a descrição do tipo de tarefa.
     * 
     * @param desc A descrição do tipo de tarefa.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
