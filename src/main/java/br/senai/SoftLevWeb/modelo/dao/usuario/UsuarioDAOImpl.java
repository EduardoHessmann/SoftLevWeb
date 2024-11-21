package br.senai.SoftLevWeb.modelo.dao.usuario;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senai.SoftLevWeb.connectionFactory.ConnectionFactory;
import br.senai.SoftLevWeb.modelo.entidade.usuario.Usuario;
import br.senai.SoftLevWeb.modelo.entidade.usuario.Usuario_;

/**
 * Implementação da interface UsuarioDAO para realizar operações de CRUD (Create, Read, Update, Delete)
 * na entidade Usuario utilizando Hibernate e JPA Criteria API.
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    private ConnectionFactory fabrica;

    /**
     * Construtor que inicializa a fábrica de conexões.
     */
    public UsuarioDAOImpl() {
        fabrica = new ConnectionFactory();
    }

    /**
     * Insere um novo usuário no banco de dados.
     * 
     * @param usuario O usuário a ser inserido no banco de dados.
     */
    public void inserirUsuario(Usuario usuario) {
        Session sessao = null;

        try {
            // Abrindo sessão para transação
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Salvando o objeto usuário
            sessao.save(usuario);

            // Commit da transação
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            // Em caso de erro, realiza rollback na transação
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            // Fechando a sessão
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    /**
     * Deleta um usuário do banco de dados.
     * 
     * @param usuario O usuário a ser deletado.
     */
    public void deletarUsuario(Usuario usuario) {
        Session sessao = null;

        try {
            // Abrindo sessão para transação
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Deletando o usuário
            sessao.delete(usuario);

            // Commit da transação
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            // Em caso de erro, realiza rollback na transação
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            // Fechando a sessão
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    /**
     * Atualiza as informações de um usuário no banco de dados.
     * 
     * @param usuario O usuário com as informações a serem atualizadas.
     */
    public void atualizarUsuario(Usuario usuario) {
        Session sessao = null;

        try {
            // Abrindo sessão para transação
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Atualizando o usuário
            sessao.update(usuario);

            // Commit da transação
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            // Em caso de erro, realiza rollback na transação
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            // Fechando a sessão
            if (sessao != null) {
                sessao.close();
            }
        }
    }

    /**
     * Busca um usuário no banco de dados pelo ID.
     * 
     * @param id O ID do usuário a ser buscado.
     * @return O usuário encontrado, ou null caso não seja encontrado.
     */
    public Usuario buscarUsuarioPorId(Long id) {
        Session sessao = null;
        Usuario usuario = null;

        try {
            // Abrindo sessão para transação
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Criando um construtor e query para a busca
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
            Root<Usuario> raizUsuario = criteria.from(Usuario.class);

            // Definindo a condição para buscar pelo ID
            criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.ID), id));

            // Executando a consulta e obtendo o resultado
            usuario = sessao.createQuery(criteria).getSingleResult();

            // Commit da transação
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            // Em caso de erro, realiza rollback na transação
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            // Fechando a sessão
            if (sessao != null) {
                sessao.close();
            }
        }

        return usuario;
    }

    /**
     * Busca um usuário no banco de dados pelo seu email e senha.
     * 
     * @param email O email do usuário.
     * @param senha A senha do usuário.
     * @return O usuário encontrado, ou null caso não seja encontrado.
     */
    public Usuario buscarUsuarioPorEmailESenha(String email, String senha) {
        Session sessao = null;
        Usuario usuario = null;

        try {
            // Abrindo sessão para transação
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Criando um construtor e query para a busca
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
            Root<Usuario> raizUsuario = criteria.from(Usuario.class);

            // Definindo as condições para busca por email e senha
            Predicate predicateUsuarioSenha = construtor.equal(raizUsuario.get(Usuario_.SENHA), senha);
            Predicate predicateUsuarioEmail = construtor.equal(raizUsuario.get(Usuario_.EMAIL), email);
            Predicate predicateUsuarioLogin = construtor.and(predicateUsuarioSenha, predicateUsuarioEmail);

            // Definindo a condição para a consulta
            criteria.where(predicateUsuarioLogin);

            // Executando a consulta e obtendo o resultado
            usuario = sessao.createQuery(criteria).getSingleResult();

            // Commit da transação
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            // Em caso de erro, realiza rollback na transação
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            // Fechando a sessão
            if (sessao != null) {
                sessao.close();
            }
        }

        return usuario;
    }

    /**
     * Busca usuários no banco de dados pelo nome.
     * 
     * @param nome O nome do usuário a ser buscado.
     * @return A lista de usuários encontrados com o nome correspondente.
     */
    public List<Usuario> buscarUsuariosPorNome(String nome) {
        Session sessao = null;
        List<Usuario> usuarios = null;

        try {
            // Abrindo sessão para transação
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Criando um construtor e query para a busca
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
            Root<Usuario> raizUsuario = criteria.from(Usuario.class);

            // Definindo a condição para busca por nome
            criteria.select(raizUsuario).where(construtor.like(raizUsuario.get(Usuario_.NOME), "%" + nome + "%"));

            // Executando a consulta e obtendo os resultados
            usuarios = sessao.createQuery(criteria).getResultList();

            // Commit da transação
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();
            // Em caso de erro, realiza rollback na transação
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            // Fechando a sessão
            if (sessao != null) {
                sessao.close();
            }
        }

        return usuarios;
    }

    /**
     * Busca todos os usuários no banco de dados.
     * 
     * @return A lista de todos os usuários cadastrados.
     */
    public List<Usuario> buscarUsuarios() {
        Session sessao = null;
        List<Usuario> usuarios = null;

        try {
            // Abrindo sessão para transação
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            // Criando um construtor e query para a busca
            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
            Root<Usuario> raizUsuario = criteria.from(Usuario.class);

            // Definindo que deseja selecionar todos os usuários
            criteria.select(raizUsuario);

            // Executando a consulta e obtendo os resultados
            usuarios = sessao.createQuery(criteria).getResultList();

            // Commit da transação
            sessao.getTransaction().commit();

        } catch (Exception sqlException) {
            sqlException.printStackTrace();

            // Em caso de erro, realiza rollback na transação
            if (sessao.getTransaction() != null) {
                sessao.getTransaction().rollback();
            }

        } finally {
            // Fechando a sessão
            if (sessao != null) {
                sessao.close();
            }
        }

        return usuarios;
    }
}
