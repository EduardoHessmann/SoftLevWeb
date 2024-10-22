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

public class TarefaDAOImpl implements TarefaDAO {

	private ConnectionFactory fabrica;

	public TarefaDAOImpl() {
		fabrica = new ConnectionFactory();
	}

	public void inserirTarefa(Tarefa Tarefa) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

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

	public void deletarTarefa(Tarefa Tarefa) {
		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

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

	public void atualizarTarefa(Tarefa tipoTarefa) {
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

	public Tarefa buscarTarefaPorId(Long id) {
		Session sessao = null;
		Tarefa tarefa = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Tarefa> criteria = construtor.createQuery(Tarefa.class);
			Root<Tarefa> raizTarefa = criteria.from(Tarefa.class);
			
			raizTarefa.fetch("tipoTarefa", JoinType.LEFT);

			criteria.select(raizTarefa).where(construtor.equal(raizTarefa.get(Tarefa_.ID), id));

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

	public List<Tarefa> buscarTarefasComTipoTarefa() {
		Session sessao = null;
		List<Tarefa> tarefas = null;

		try {
			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
			CriteriaQuery<Tarefa> criteria = construtor.createQuery(Tarefa.class);
			Root<Tarefa> raizTarefa = criteria.from(Tarefa.class);
			
			raizTarefa.fetch("tipoTarefa", JoinType.LEFT);

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

}
