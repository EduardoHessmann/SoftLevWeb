package br.senai.SoftLevWeb.modelo.dao.tipoTarefa;

import org.hibernate.Session;

import br.senai.SoftLevWeb.connectionFactory.ConnectionFactory;
import br.senai.SoftLevWeb.modelo.entidade.tipoTarefa.TipoTarefa;

public class TipoTarefaDAOImpl implements TipoTarefaDAO{
	
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
	
	

}
