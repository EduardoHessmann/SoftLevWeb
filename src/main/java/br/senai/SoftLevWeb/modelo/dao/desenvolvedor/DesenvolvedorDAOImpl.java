package br.senai.SoftLevWeb.modelo.dao.desenvolvedor;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import br.senai.SoftLevWeb.connectionFactory.ConnectionFactory;
import br.senai.SoftLevWeb.modelo.entidade.desenvolvedor.Desenvolvedor;
import br.senai.SoftLevWeb.modelo.entidade.desenvolvedor.Desenvolvedor_;

public class DesenvolvedorDAOImpl implements DesenvolvedorDAO {

    private ConnectionFactory fabrica;

    // Construtor que inicializa a fábrica de conexões.
    public DesenvolvedorDAOImpl() {
        fabrica = new ConnectionFactory();
    }

    /**
     * Insere um novo desenvolvedor no banco de dados.
     * 
     * @param desenvolvedor O objeto Desenvolvedor a ser inserido.
     */
    public void inserirDesenvolvedor(Desenvolvedor desenvolvedor) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Salva o desenvolvedor no banco de dados.
            sessao.save(desenvolvedor);

            // Confirma a transação.
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
     * Deleta um desenvolvedor do banco de dados.
     * 
     * @param desenvolvedor O objeto Desenvolvedor a ser deletado.
     */
    public void deletarDesenvolvedor(Desenvolvedor desenvolvedor) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Deleta o desenvolvedor do banco de dados.
            sessao.delete(desenvolvedor);

            // Confirma a transação.
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
     * Atualiza os dados de um desenvolvedor no banco de dados.
     * 
     * @param desenvolvedor O objeto Desenvolvedor com os dados atualizados.
     */
    public void atualizarDesenvolvedor(Desenvolvedor desenvolvedor) {
        Session sessao = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Atualiza o desenvolvedor no banco de dados.
            sessao.update(desenvolvedor);

            // Confirma a transação.
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
     * Busca um desenvolvedor pelo seu ID.
     * 
     * @param id O ID do desenvolvedor a ser buscado.
     * @return O objeto Desenvolvedor correspondente ao ID, ou null se não encontrado.
     */
    public Desenvolvedor buscarDesenvolvedorPorId(Long id) {
        Session sessao = null;
        Desenvolvedor desenvolvedor = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Cria uma consulta para buscar o desenvolvedor pelo ID.
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Desenvolvedor> criteria = construtor.createQuery(Desenvolvedor.class);
            Root<Desenvolvedor> raizDesenvolvedor = criteria.from(Desenvolvedor.class);

            criteria.select(raizDesenvolvedor).where(construtor.equal(raizDesenvolvedor.get(Desenvolvedor_.ID), id));

            // Executa a consulta e retorna o resultado.
            desenvolvedor = sessao.createQuery(criteria).getSingleResult();

            // Confirma a transação.
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

        return desenvolvedor;
    }

    /**
     * Retorna uma lista com todos os desenvolvedores cadastrados.
     * 
     * @return Lista de desenvolvedores.
     */
    public List<Desenvolvedor> buscarDesenvolvedores() {
        Session sessao = null;
        List<Desenvolvedor> desenvolvedores = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Cria uma consulta para buscar todos os desenvolvedores.
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Desenvolvedor> criteria = construtor.createQuery(Desenvolvedor.class);
            Root<Desenvolvedor> raizDesenvolvedor = criteria.from(Desenvolvedor.class);

            criteria.select(raizDesenvolvedor);

            // Executa a consulta e retorna os resultados.
            desenvolvedores = sessao.createQuery(criteria).getResultList();

            // Confirma a transação.
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

        return desenvolvedores;
    }

    /**
     * Busca desenvolvedores pelo nome, com suporte a buscas parciais.
     * 
     * @param nome O nome ou parte do nome do desenvolvedor.
     * @return Lista de desenvolvedores que correspondem ao nome informado.
     */
    public List<Desenvolvedor> buscarDesenvolvedoresPorNome(String nome) {
        Session sessao = null;
        List<Desenvolvedor> desenvolvedores = null;
        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Cria uma consulta para buscar desenvolvedores por nome.
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Desenvolvedor> criteria = construtor.createQuery(Desenvolvedor.class);
            Root<Desenvolvedor> raizDesenvolvedor = criteria.from(Desenvolvedor.class);

            criteria.select(raizDesenvolvedor).where(construtor.like(raizDesenvolvedor.get(Desenvolvedor_.NOME), "%" + nome + "%"));

            // Executa a consulta e retorna os resultados.
            desenvolvedores = sessao.createQuery(criteria).getResultList();

            // Confirma a transação.
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

        return desenvolvedores;
    }
}
