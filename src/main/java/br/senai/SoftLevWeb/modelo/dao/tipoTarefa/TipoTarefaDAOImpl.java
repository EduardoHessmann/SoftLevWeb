package br.senai.SoftLevWeb.modelo.dao.tipoTarefa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senai.SoftLevWeb.connectionFactory.ConnectionFactory;
import br.senai.SoftLevWeb.modelo.entidade.tipoTarefa.TipoTarefa;
import br.senai.SoftLevWeb.modelo.entidade.tipoTarefa.TipoTarefa_;

public class TipoTarefaDAOImpl implements TipoTarefaDAO {

    // A conexão com o banco de dados
    private ConnectionFactory fabrica;

    // Construtor padrão, inicializando a fábrica de conexões
    public TipoTarefaDAOImpl() {
        fabrica = new ConnectionFactory();
    }

    /**
     * Insere um novo TipoTarefa no banco de dados.
     * 
     * @param tipoTarefa O objeto TipoTarefa a ser inserido.
     */
    public void inserirTipoTarefa(TipoTarefa tipoTarefa) {
        Session sessao = null;

        try {
            sessao = fabrica.getConexao().openSession();  // Obtém uma sessão do Hibernate
            sessao.beginTransaction();  // Inicia uma transação

            sessao.save(tipoTarefa);  // Salva o objeto TipoTarefa no banco

            sessao.getTransaction().commit();  // Comita a transação

        } catch (Exception sqlException) {
            sqlException.printStackTrace();  // Exibe o erro no console

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();  // Reverte a transação em caso de erro
            }

        } finally {
            if (sessao != null) {
                sessao.close();  // Fecha a sessão
            }
        }
    }

    /**
     * Deleta um TipoTarefa existente no banco de dados.
     * 
     * @param tipoTarefa O objeto TipoTarefa a ser deletado.
     */
    public void deletarTipoTarefa(TipoTarefa tipoTarefa) {
        Session sessao = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            sessao.delete(tipoTarefa);  // Deleta o TipoTarefa do banco

            sessao.getTransaction().commit();  // Comita a transação

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();  // Reverte a transação em caso de erro
            }

        } finally {
            if (sessao != null) {
                sessao.close();  // Fecha a sessão
            }
        }
    }

    /**
     * Atualiza um TipoTarefa existente no banco de dados.
     * 
     * @param tipoTarefa O objeto TipoTarefa a ser atualizado.
     */
    public void atualizarTipoTarefa(TipoTarefa tipoTarefa) {
        Session sessao = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            sessao.update(tipoTarefa);  // Atualiza o objeto TipoTarefa no banco

            sessao.getTransaction().commit();  // Comita a transação

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();  // Reverte a transação em caso de erro
            }

        } finally {
            if (sessao != null) {
                sessao.close();  // Fecha a sessão
            }
        }
    }

    /**
     * Busca um TipoTarefa no banco de dados através de seu ID.
     * 
     * @param id O ID do TipoTarefa a ser buscado.
     * @return O objeto TipoTarefa encontrado, ou null se não encontrado.
     */
    public TipoTarefa buscarTipoTarefaPorId(Long id) {
        Session sessao = null;
        TipoTarefa tipoTarefa = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<TipoTarefa> criteria = construtor.createQuery(TipoTarefa.class);
            Root<TipoTarefa> raizTipoTarefa = criteria.from(TipoTarefa.class);

            criteria.select(raizTipoTarefa).where(construtor.equal(raizTipoTarefa.get(TipoTarefa_.ID), id));

            tipoTarefa = sessao.createQuery(criteria).getSingleResult();  // Busca o TipoTarefa pelo ID

            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();  // Reverte a transação em caso de erro
            }

        } finally {
            if (sessao != null) {
                sessao.close();  // Fecha a sessão
            }
        }

        return tipoTarefa;  // Retorna o TipoTarefa encontrado
    }

    /**
     * Busca todos os TipoTarefas no banco de dados.
     * 
     * @return Uma lista de objetos TipoTarefa.
     */
    public List<TipoTarefa> buscarTiposTarefa() {

        Session sessao = null;
        List<TipoTarefa> tiposTarefa = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            CriteriaBuilder construtor = sessao.getCriteriaBuilder();

            CriteriaQuery<TipoTarefa> criteria = construtor.createQuery(TipoTarefa.class);
            Root<TipoTarefa> raizTipoTarefa = criteria.from(TipoTarefa.class);

            criteria.select(raizTipoTarefa);  // Seleciona todos os TipoTarefas

            tiposTarefa = sessao.createQuery(criteria).getResultList();  // Executa a consulta e armazena os resultados

            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();  // Reverte a transação em caso de erro
            }

        } finally {
            if (sessao != null) {
                sessao.close();  // Fecha a sessão
            }
        }

        return tiposTarefa;  // Retorna a lista de TipoTarefas
    }

    /**
     * Busca TipoTarefas no banco de dados pelo nome.
     * 
     * @param nome O nome do TipoTarefa a ser buscado.
     * @return Uma lista de TipoTarefas cujo nome contém a string fornecida.
     */
    public List<TipoTarefa> buscarTiposTarefaPorNome(String nome) {
        Session sessao = null;
        List<TipoTarefa> tiposTareas = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<TipoTarefa> criteria = construtor.createQuery(TipoTarefa.class);
            Root<TipoTarefa> raizTipoTarefa = criteria.from(TipoTarefa.class);

            criteria.select(raizTipoTarefa).where(construtor.like(raizTipoTarefa.get(TipoTarefa_.NOME), "%" + nome + "%"));

            tiposTareas = sessao.createQuery(criteria).getResultList();  // Executa a consulta e armazena os resultados

            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();  // Reverte a transação em caso de erro
            }

        } finally {
            if (sessao != null) {
                sessao.close();  // Fecha a sessão
            }
        }
        return tiposTareas;  // Retorna a lista de TipoTarefas encontradas
    }
}
