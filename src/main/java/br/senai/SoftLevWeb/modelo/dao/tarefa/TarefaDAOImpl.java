package br.senai.SoftLevWeb.modelo.dao.tarefa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senai.SoftLevWeb.connectionFactory.ConnectionFactory;
import br.senai.SoftLevWeb.modelo.entidade.tarefa.Tarefa;
import br.senai.SoftLevWeb.modelo.entidade.tarefa.Tarefa_;

/**
 * Implementação da interface TarefaDAO que define os métodos para realizar operações
 * de CRUD (Create, Read, Update, Delete) na entidade Tarefa.
 */
public class TarefaDAOImpl implements TarefaDAO {

    private ConnectionFactory fabrica;

    /**
     * Construtor que inicializa a fábrica de conexões para o banco de dados.
     */
    public TarefaDAOImpl() {
        fabrica = new ConnectionFactory();
    }

    /**
     * Insere uma nova Tarefa no banco de dados.
     *
     * @param Tarefa A tarefa a ser inserida.
     */
    public void inserirTarefa(Tarefa Tarefa) {
        Session sessao = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Salva a tarefa no banco de dados
            sessao.save(Tarefa);

            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    /**
     * Deleta uma Tarefa existente no banco de dados.
     *
     * @param Tarefa A tarefa a ser deletada.
     */
    public void deletarTarefa(Tarefa Tarefa) {
        Session sessao = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Deleta a tarefa do banco de dados
            sessao.delete(Tarefa);

            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    /**
     * Atualiza os dados de uma Tarefa existente no banco de dados.
     *
     * @param tipoTarefa A tarefa a ser atualizada.
     */
    public void atualizarTarefa(Tarefa tipoTarefa) {
        Session sessao = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Atualiza os dados da tarefa no banco de dados
            sessao.update(tipoTarefa);

            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    /**
     * Busca uma tarefa pelo seu ID.
     *
     * @param id O ID da tarefa a ser buscada.
     * @return A tarefa correspondente ao ID fornecido.
     */
    public Tarefa buscarTarefaPorId(Long id) {
        Session sessao = null;
        Tarefa tarefa = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Cria um construtor de consulta
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Tarefa> criteria = construtor.createQuery(Tarefa.class);
            Root<Tarefa> raizTarefa = criteria.from(Tarefa.class);

            // Faz um join com as entidades relacionadas
            raizTarefa.fetch("tipoTarefa", JoinType.LEFT);
            raizTarefa.fetch("desenvolvedor", JoinType.LEFT);

            // Define a condição de busca pela ID
            criteria.select(raizTarefa).where(construtor.equal(raizTarefa.get(Tarefa_.ID), id));

            // Executa a consulta e retorna o resultado
            tarefa = sessao.createQuery(criteria).getSingleResult();

            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }

        return tarefa;
    }

    /**
     * Busca todas as tarefas com seus tipos de tarefa e desenvolvedores relacionados.
     *
     * @return Lista de tarefas com os tipos e desenvolvedores associados.
     */
    public List<Tarefa> buscarTarefasComTipoTarefa() {
        Session sessao = null;
        List<Tarefa> tarefas = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Cria um construtor de consulta
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Tarefa> criteria = construtor.createQuery(Tarefa.class);
            Root<Tarefa> raizTarefa = criteria.from(Tarefa.class);

            // Faz um join com as entidades relacionadas
            raizTarefa.fetch("tipoTarefa", JoinType.LEFT);
            raizTarefa.fetch("desenvolvedor", JoinType.LEFT);

            // Executa a consulta para buscar todas as tarefas
            criteria.select(raizTarefa);

            tarefas = sessao.createQuery(criteria).getResultList();

            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }

        return tarefas;
    }

    /**
     * Busca as tarefas pelo nome.
     *
     * @param nome O nome da tarefa a ser buscada.
     * @return Lista de tarefas que contêm o nome fornecido.
     */
    public List<Tarefa> buscarTarefasPorNome(String nome) {
        Session sessao = null;
        List<Tarefa> tarefas = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Cria um construtor de consulta
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Tarefa> criteria = construtor.createQuery(Tarefa.class);
            Root<Tarefa> raizTarefa = criteria.from(Tarefa.class);
            
            // Faz um join com as entidades relacionadas
            raizTarefa.fetch("tipoTarefa", JoinType.LEFT);
            raizTarefa.fetch("desenvolvedor", JoinType.LEFT);

            // Define a condição de busca pelo nome
            criteria.select(raizTarefa).where(construtor.like(raizTarefa.get(Tarefa_.NOME), "%" + nome + "%"));

            // Executa a consulta e retorna o resultado
            tarefas = sessao.createQuery(criteria).getResultList();

            sessao.getTransaction().commit();

        } catch (Exception sqlException) {

            sqlException.printStackTrace();
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            if (sessao != null) {
                sessao.close();
            }
        }
        return tarefas;
    }

}
