package br.senai.SoftLevWeb.modelo.dao.desenvolvedor;

import java.util.List;

import br.senai.SoftLevWeb.modelo.entidade.desenvolvedor.Desenvolvedor;

public interface DesenvolvedorDAO {
	
	void inserirDesenvolvedor(Desenvolvedor desenvolvedor);

	void deletarDesenvolvedor(Desenvolvedor desenvolvedor);

	void atualizarDesenvolvedor(Desenvolvedor desenvolvedor);
	
	Desenvolvedor buscarDesenvolvedorPorId(Long id);
	
	public List<Desenvolvedor> buscarDesenvolvedores();
	
	public List<Desenvolvedor> buscarDesenvolvedoresPorNome(String nome);

}
