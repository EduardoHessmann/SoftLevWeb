package br.senai.SoftLevWeb.modelo.dao.tarefa;

import java.util.List;

import br.senai.SoftLevWeb.modelo.entidade.tarefa.Tarefa;

public interface TarefaDAO {
	
	void inserirTarefa(Tarefa Tarefa);

	void deletarTarefa(Tarefa Tarefa);

	void atualizarTarefa(Tarefa Tarefa);
	
	Tarefa buscarTarefaPorId(Long id);
	
	List<Tarefa> buscarTarefasComTipoTarefa();
	
	List<Tarefa> buscarTarefasPorNome(String nome);

}
