package br.senai.SoftLevWeb.modelo.dao.tipoTarefa;

import br.senai.SoftLevWeb.modelo.entidade.tipoTarefa.TipoTarefa;

public interface TipoTarefaDAO {
	
	void inserirTipoTarefa(TipoTarefa tipoTarefa);

	void deletarTipoTarefa(TipoTarefa tipoTarefa);

	void atualizarTipoTarefa(TipoTarefa tipoTarefa);

}
