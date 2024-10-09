package br.senai.SoftLevWeb.modelo.dao.desenvolvedor;

import br.senai.SoftLevWeb.modelo.entidade.desenvolvedor.Desenvolvedor;

public interface DesenvolvedorDAO {
	
	void inserirDesenvovedor(Desenvolvedor desenvolvedor);

	void deletarDesenvolvedor(Desenvolvedor desenvolvedor);

	void atualizarDesenvolvedor(Desenvolvedor desenvolvedor);
	
	Desenvolvedor buscarDesenvolvedorPorId(Long id);

}
