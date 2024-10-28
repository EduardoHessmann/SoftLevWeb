package br.senai.SoftLevWeb.modelo.dao.usuario;

import java.util.List;

import br.senai.SoftLevWeb.modelo.entidade.usuario.Usuario;

public interface UsuarioDAO {
	
	void inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarUsuario(Usuario usuario);
	
	Usuario buscarUsuarioPorId(Long id);
	
	Usuario buscarUsuarioPorEmailESenha(String email, String senha);
	
	Usuario buscarUsuarioPorNome(String nome);
	
	List<Usuario> buscarUsuarios();

}
