package br.senai.SoftLevWeb.connectionFactory;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConnectionFactory {
	
	public SessionFactory getConexao() {
		 
		Configuration configuracao = new Configuration();
 
		configuracao.addAnnotatedClass(br.senai.SoftLevWeb.modelo.entidade.usuario.Usuario.class);
		configuracao.addAnnotatedClass(br.senai.SoftLevWeb.modelo.entidade.desenvolvedor.Desenvolvedor.class);
		configuracao.addAnnotatedClass(br.senai.SoftLevWeb.modelo.entidade.tarefa.Tarefa.class);
		configuracao.addAnnotatedClass(br.senai.SoftLevWeb.modelo.entidade.tipoTarefa.TipoTarefa.class);
		
		configuracao.configure("hibernate.cfg.xml");
 
		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);
 
		return fabricaSessao;
	}

}
