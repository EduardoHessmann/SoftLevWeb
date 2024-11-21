package br.senai.SoftLevWeb.modelo.dao.tipoTarefa;

import java.util.List;

import br.senai.SoftLevWeb.modelo.entidade.tipoTarefa.TipoTarefa;

public interface TipoTarefaDAO {
	
	void inserirTipoTarefa(TipoTarefa tipoTarefa);

	void deletarTipoTarefa(TipoTarefa tipoTarefa);

	void atualizarTipoTarefa(TipoTarefa tipoTarefa);
	
	TipoTarefa buscarTipoTarefaPorId(Long id);
	
	List<TipoTarefa> buscarTiposTarefa();
	
	List<TipoTarefa> buscarTiposTarefaPorNome(String nome);

}
