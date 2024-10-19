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

	private ConnectionFactory fabrica;

	public TipoTarefaDAOImpl() {
		fabrica = new ConnectionFactory();
	}

	public void inserirTipoTarefa(TipoTarefa tipoTarefa) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(tipoTarefa);

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

	public void deletarTipoTarefa(TipoTarefa tipoTarefa) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(tipoTarefa);

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

	public void atualizarTipoTarefa(TipoTarefa tipoTarefa) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

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

			tipoTarefa = sessao.createQuery(criteria).getSingleResult();

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

		return tipoTarefa;
	}

	public List<TipoTarefa> buscarTiposTarefa() {

	    Session sessao = null;
	    List<TipoTarefa> tiposTarefa = null;

	    try {

	        sessao = fabrica.getConexao().openSession();
	        sessao.beginTransaction();

	        CriteriaBuilder construtor = sessao.getCriteriaBuilder();

	        CriteriaQuery<TipoTarefa> criteria = construtor.createQuery(TipoTarefa.class);
	        Root<TipoTarefa> raizTipoTarefa = criteria.from(TipoTarefa.class);

	        criteria.select(raizTipoTarefa);

	        tiposTarefa = sessao.createQuery(criteria).getResultList();

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

	    return tiposTarefa;
	}


}
