package br.senai.SoftLevWeb.modelo.dao.usuario;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.senai.SoftLevWeb.connectionFactory.ConnectionFactory;
import br.senai.SoftLevWeb.modelo.entidade.usuario.Usuario;
import br.senai.SoftLevWeb.modelo.entidade.usuario.Usuario_;

public class UsuarioDAOImpl implements UsuarioDAO {

	private ConnectionFactory fabrica;

	public UsuarioDAOImpl() {
		fabrica = new ConnectionFactory();
	}

	public void inserirUsuario(Usuario usuario) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(usuario);

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

	public void deletarUsuario(Usuario usuario) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(usuario);

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

	public void atualizarUsuario(Usuario usuario) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(usuario);

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

	public Usuario buscarUsuarioPorId(Long id) {

		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.ID), id));

			usuario = sessao.createQuery(criteria).getSingleResult();

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

		return usuario;

	}

	public Usuario buscarUsuarioPorEmailESenha(String email, String senha) {

		Session sessao = null;
		Usuario usuario = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
			Root<Usuario> raizUsuario = criteria.from(Usuario.class);

			criteria.select(raizUsuario).where(construtor.equal(raizUsuario.get(Usuario_.EMAIL), email),
					construtor.equal(raizUsuario.get(Usuario_.SENHA), senha));

			Predicate predicateUsuarioSenha = construtor.equal(raizUsuario.get(Usuario_.SENHA), senha);
			Predicate predicateUsuarioEmail = construtor.equal(raizUsuario.get(Usuario_.EMAIL), email);
			Predicate predicateUsuarioLogin = construtor.and(predicateUsuarioSenha, predicateUsuarioEmail);

			criteria.where(predicateUsuarioLogin);

			usuario = sessao.createQuery(criteria).getSingleResult();

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

		return usuario;
	}

	public Usuario buscarUsuarioPorNome(String nome) {
	    Session sessao = null;
	    Usuario usuario = null;

	    try {
	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();

	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();
	        CriteriaQuery<Usuario> criteria = construtor.createQuery(Usuario.class);
	        Root<Usuario> raizUsuario = criteria.from(Usuario.class);

	        criteria.select(raizUsuario)
	                .where(construtor.like(raizUsuario.get(Usuario_.NOME), "%" + nome + "%"));
	        
	        usuario = sessao.createQuery(criteria).uniqueResult();

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
	    return usuario;
	}

}