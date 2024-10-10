package br.senai.SoftLevWeb.modelo.dao.tarefa;

import org.hibernate.Session;

import br.senai.SoftLevWeb.connectionFactory.ConnectionFactory;
import br.senai.SoftLevWeb.modelo.entidade.tarefa.Tarefa;

public class TarefaDAOImpl implements TarefaDAO{
	
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
	
	

}
