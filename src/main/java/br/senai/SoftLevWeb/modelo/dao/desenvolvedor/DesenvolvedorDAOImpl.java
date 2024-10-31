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

    public DesenvolvedorDAOImpl() {
        fabrica = new ConnectionFactory();
    }

    public void inserirDesenvolvedor(Desenvolvedor desenvolvedor) {
        Session sessao = null;

        try {

            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            sessao.save(desenvolvedor);

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

    public void deletarDesenvolvedor(Desenvolvedor desenvolvedor) {
        Session sessao = null;

        try {

            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            sessao.delete(desenvolvedor);

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

    public void atualizarDesenvolvedor(Desenvolvedor desenvolvedor) {
        Session sessao = null;

        try {

            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            sessao.update(desenvolvedor);

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

    public Desenvolvedor buscarDesenvolvedorPorId(Long id) {

        Session sessao = null;
        Desenvolvedor desenvolvedor = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            CriteriaBuilder construtor = sessao.getCriteriaBuilder();
            CriteriaQuery<Desenvolvedor> criteria = construtor.createQuery(Desenvolvedor.class);
            Root<Desenvolvedor> raizDesenvolvedor = criteria.from(Desenvolvedor.class);

            criteria.select(raizDesenvolvedor).where(construtor.equal(raizDesenvolvedor.get(Desenvolvedor_.ID), id));

            desenvolvedor = sessao.createQuery(criteria).getSingleResult();

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
    
    public List<Desenvolvedor> buscarDesenvolvedores() {

        Session sessao = null;
        List<Desenvolvedor> desenvolvedores = null;

        try {
            sessao = fabrica.getConexao().openSession();
            sessao.beginTransaction();

            CriteriaBuilder construtor = sessao.getCriteriaBuilder();

            CriteriaQuery<Desenvolvedor> criteria = construtor.createQuery(Desenvolvedor.class);
            Root<Desenvolvedor> raizDesenvolvedor = criteria.from(Desenvolvedor.class);

            criteria.select(raizDesenvolvedor);

            desenvolvedores = sessao.createQuery(criteria).getResultList();

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