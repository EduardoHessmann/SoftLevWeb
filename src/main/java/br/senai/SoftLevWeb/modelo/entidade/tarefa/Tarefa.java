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

/**
 * Classe que representa a entidade Tarefa no banco de dados.
 * Esta classe utiliza a estratégia de herança JOINED no JPA, permitindo a herança de subclasses.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tarefa")
public class Tarefa implements Serializable {

    // Serial version UID para garantir a compatibilidade durante a serialização
    private static final long serialVersionUID = 5007407356250769572L;

    // Atributo de ID da entidade, gerado automaticamente pelo banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarefa")
    private Long id;

    // Atributo que armazena o nome da tarefa
    @Column(name = "nome_tarefa", length = 30, nullable = false)
    private String nome;

    // Atributo que armazena a descrição da tarefa
    @Column(name = "desc_tarefa", length = 60, nullable = false)
    private String desc;

    // Relacionamento muitos-para-um (Many-to-One) com a entidade TipoTarefa
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_tarefa", referencedColumnName = "id_tipo_tarefa")
    private TipoTarefa tipoTarefa;

    // Relacionamento um-para-um (One-to-One) com a entidade Desenvolvedor
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_desenvolvedor", referencedColumnName = "id_desenvolvedor")
    private Desenvolvedor desenvolvedor;

    /**
     * Construtor que inicializa todos os campos da entidade.
     * 
     * @param id O ID da tarefa.
     * @param nome O nome da tarefa.
     * @param desc A descrição da tarefa.
     * @param tipoTarefa O tipo da tarefa.
     * @param desenvolvedor O desenvolvedor responsável pela tarefa.
     */
    public Tarefa(Long id, String nome, String desc, TipoTarefa tipoTarefa, Desenvolvedor desenvolvedor) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.tipoTarefa = tipoTarefa;
        this.desenvolvedor = desenvolvedor;
    }

    /**
     * Construtor que inicializa todos os campos, exceto o ID.
     * 
     * @param nome O nome da tarefa.
     * @param desc A descrição da tarefa.
     * @param tipoTarefa O tipo da tarefa.
     * @param desenvolvedor O desenvolvedor responsável pela tarefa.
     */
    public Tarefa(String nome, String desc, TipoTarefa tipoTarefa, Desenvolvedor desenvolvedor) {
        this.nome = nome;
        this.desc = desc;
        this.tipoTarefa = tipoTarefa;
        this.desenvolvedor = desenvolvedor;
    }

    /**
     * Construtor padrão da classe, necessário para o JPA.
     */
    public Tarefa() {}

    /**
     * Obtém o ID da tarefa.
     * 
     * @return O ID da tarefa.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID da tarefa.
     * 
     * @param id O ID da tarefa.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome da tarefa.
     * 
     * @return O nome da tarefa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da tarefa.
     * 
     * @param nome O nome da tarefa.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a descrição da tarefa.
     * 
     * @return A descrição da tarefa.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Define a descrição da tarefa.
     * 
     * @param desc A descrição da tarefa.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Obtém o tipo de tarefa associado a esta tarefa.
     * 
     * @return O tipo de tarefa.
     */
    public TipoTarefa getTipoTarefa() {
        return tipoTarefa;
    }

    /**
     * Define o tipo de tarefa para esta tarefa.
     * 
     * @param tipoTarefa O tipo de tarefa.
     */
    public void setTipoTarefa(TipoTarefa tipoTarefa) {
        this.tipoTarefa = tipoTarefa;
    }

    /**
     * Obtém o desenvolvedor responsável pela tarefa.
     * 
     * @return O desenvolvedor responsável.
     */
    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    /**
     * Define o desenvolvedor responsável pela tarefa.
     * 
     * @param desenvolvedor O desenvolvedor responsável.
     */
    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

}
