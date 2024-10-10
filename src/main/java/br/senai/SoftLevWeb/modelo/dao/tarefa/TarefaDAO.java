package br.senai.SoftLevWeb.modelo.dao.tarefa;

import br.senai.SoftLevWeb.modelo.entidade.tarefa.Tarefa;

public interface TarefaDAO {
	
	void inserirTarefa(Tarefa Tarefa);

	void deletarTarefa(Tarefa Tarefa);

	void atualizarTarefa(Tarefa Tarefa);

}
