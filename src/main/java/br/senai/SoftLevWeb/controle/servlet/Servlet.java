package br.senai.SoftLevWeb.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.SoftLevWeb.modelo.dao.desenvolvedor.DesenvolvedorDAO;
import br.senai.SoftLevWeb.modelo.dao.desenvolvedor.DesenvolvedorDAOImpl;
import br.senai.SoftLevWeb.modelo.dao.tarefa.TarefaDAO;
import br.senai.SoftLevWeb.modelo.dao.tarefa.TarefaDAOImpl;
import br.senai.SoftLevWeb.modelo.dao.tipoTarefa.TipoTarefaDAO;
import br.senai.SoftLevWeb.modelo.dao.tipoTarefa.TipoTarefaDAOImpl;
import br.senai.SoftLevWeb.modelo.dao.usuario.UsuarioDAO;
import br.senai.SoftLevWeb.modelo.dao.usuario.UsuarioDAOImpl;
import br.senai.SoftLevWeb.modelo.entidade.desenvolvedor.Desenvolvedor;
import br.senai.SoftLevWeb.modelo.entidade.tarefa.Tarefa;
import br.senai.SoftLevWeb.modelo.entidade.tipoTarefa.TipoTarefa;
import br.senai.SoftLevWeb.modelo.entidade.usuario.Usuario;

/**
 * Servlet principal para controle das requisições e gerenciamento das ações
 * dentro da aplicação web.
 */
@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 8840029940617992062L;

	// Declaração dos DAOs utilizados na aplicação
	private UsuarioDAO usuarioDAO;
	private TarefaDAO tarefaDAO;
	private TipoTarefaDAO tipoTarefaDAO;
	private DesenvolvedorDAO desenvolvedorDAO;

	/**
	 * Inicializa os DAOs da aplicação. Este método é chamado ao carregar o servlet.
	 */
	public void init() {
		usuarioDAO = new UsuarioDAOImpl();
		desenvolvedorDAO = new DesenvolvedorDAOImpl();
		tarefaDAO = new TarefaDAOImpl();
		tipoTarefaDAO = new TipoTarefaDAOImpl();
	}

	/**
	 * Redireciona as requisições POST para o método doGet.
	 *
	 * @param request  Objeto HttpServletRequest contendo informações da requisição.
	 * @param response Objeto HttpServletResponse para manipulação da resposta.
	 * @throws ServletException Em caso de erro durante o processamento da
	 *                          requisição.
	 * @throws IOException      Em caso de erro de entrada/saída.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Processa requisições GET e redireciona para os métodos correspondentes
	 * conforme o caminho da ação especificado na URL.
	 *
	 * @param request  Objeto HttpServletRequest contendo informações da requisição.
	 * @param response Objeto HttpServletResponse para manipulação da resposta.
	 * @throws ServletException Em caso de erro durante o processamento da
	 *                          requisição.
	 * @throws IOException      Em caso de erro de entrada/saída.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			// Seleciona a ação com base no caminho da URL
			switch (action) {
			case "/login":
				mostrarLogin(request, response);
				break;

			case "/logar":
				logar(request, response);
				break;

			case "/aviso-desenvolvedor-com-tarefa":
				mostrarAvisoDesenvolvedorComTarefa(request, response);
				break;

			case "/home":
				mostrarHome(request, response);
				break;

			case "/cadastro-usuario":
				mostrarCadastroUsuario(request, response);
				break;

			case "/cadastro-tarefa":
				mostrarCadastroTarefa(request, response);
				break;

			case "/editar-tarefa":
				mostrarEditarTarefa(request, response);
				break;

			case "/deletar-tarefa":
				deletarTarefa(request, response);
				break;

			case "/resultado-pesquisa-tarefa":
				mostrarResultadoPesquisaTarefa(request, response);
				break;

			case "/resultado-pesquisa-desenvolvedor":
				mostrarResultadoPesquisaDesenvolvedor(request, response);
				break;

			case "/atualizar-tarefa":
				atualizarTarefa(request, response);
				break;

			case "/deletar-desenvolvedor":
				deletarDesenvolvedor(request, response);
				break;

			case "/cadastro-tipo-tarefa":
				mostrarCadastroTipoTarefa(request, response);
				break;

			case "/editar-tipo-tarefa":
				mostrarEditarTipoTarefa(request, response);
				break;

			case "/atualizar-tipo-tarefa":
				atualizarTipoTarefa(request, response);
				break;

			case "/deletar-tipo-tarefa":
				deletarTipoTarefa(request, response);
				break;

			case "/visualizar-tipos-tarefa":
				visualizarTiposTarefa(request, response);
				break;

			case "/resultado-pesquisa-tipo-tarefa":
				mostrarResultadoPesquisaTipoTarefa(request, response);
				break;

			case "/resultado-pesquisa-usuario":
				mostrarResultadoPesquisaUsuario(request, response);
				break;

			case "/cadastro-desenvolvedor":
				mostrarCadastroDesenvolvedor(request, response);
				break;

			case "/visualizar-usuarios":
				mostrarVisualizarUsuarios(request, response);
				break;

			case "/visualizar-desenvolvedores":
				mostrarVisualizarDesenvolvedores(request, response);
				break;

			case "/inserir-usuario":
				inserirUsuario(request, response);
				break;

			case "/editar-usuario":
				mostrarEditarUsuario(request, response);
				break;

			case "/editar-desenvolvedor":
				mostrarEditarDesenvolvedor(request, response);
				break;

			case "/atualizar-usuario":
				atualizarUsuario(request, response);
				break;

			case "/deletar-usuario":
				deletarUsuario(request, response);
				break;

			case "/inserir-tarefa":
				inserirTarefa(request, response);
				break;

			case "/tipo-tarefa-tem-tarefa":
				mostrarTipoTarefaTemTarefa(request, response);
				break;

			case "/inserir-tipo-tarefa":
				inserirTipoTarefa(request, response);
				break;

			default:
				mostrarLogin(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * Encaminha a requisição para a página de login. Lida com a navegação para a
	 * tela de autenticação de usuários.
	 */
	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Encaminha a requisição para a página de aviso sobre desenvolvedores com
	 * tarefas associadas. Usado para exibir mensagens específicas relacionadas aos
	 * desenvolvedores.
	 */
	private void mostrarAvisoDesenvolvedorComTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/aviso-desenvolvedor-com-tarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Recupera todas as tarefas e seus tipos associados do banco de dados e
	 * encaminha essas informações para a página inicial do sistema.
	 */
	private void mostrarHome(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Tarefa> tarefas = tarefaDAO.buscarTarefasComTipoTarefa();
		request.setAttribute("tarefas", tarefas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Realiza a pesquisa de tarefas com base no nome informado e encaminha os
	 * resultados para a página de exibição dos resultados.
	 */
	private void mostrarResultadoPesquisaTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Tarefa> tarefas = tarefaDAO.buscarTarefasPorNome(request.getParameter("nomePesquisa"));
		request.setAttribute("tarefas", tarefas);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/resultado-pesquisa-tarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Encaminha a requisição para a página de cadastro de usuários. Exibe o
	 * formulário para adicionar novos usuários ao sistema.
	 */
	private void mostrarCadastroUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-usuario.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Recupera todos os usuários do banco de dados e encaminha para a página de
	 * exibição. Permite visualizar a lista de usuários cadastrados no sistema.
	 */
	private void mostrarVisualizarUsuarios(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Usuario> usuarios = usuarioDAO.buscarUsuarios();
		request.setAttribute("usuarios", usuarios);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/visualizar-usuarios.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Recupera todos os desenvolvedores do banco de dados e encaminha para a página
	 * de exibição. Permite visualizar a lista de desenvolvedores cadastrados.
	 */
	private void mostrarVisualizarDesenvolvedores(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Desenvolvedor> desenvolvedores = desenvolvedorDAO.buscarDesenvolvedores();
		request.setAttribute("desenvolvedores", desenvolvedores);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/visualizar-desenvolvedores.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Realiza a pesquisa de desenvolvedores com base no nome informado e encaminha
	 * os resultados para a página de exibição.
	 */
	private void mostrarResultadoPesquisaDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Desenvolvedor> desenvolvedores = desenvolvedorDAO
				.buscarDesenvolvedoresPorNome(request.getParameter("nome"));
		request.setAttribute("desenvolvedores", desenvolvedores);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/resultado-pesquisa-desenvolvedor.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Recupera os dados de um desenvolvedor específico com base no ID fornecido e
	 * encaminha as informações para a página de edição.
	 */
	private void mostrarEditarDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Usuario desenvolvedor = usuarioDAO.buscarUsuarioPorId(Long.parseLong(request.getParameter("id")));
		request.setAttribute("desenvolvedor", desenvolvedor);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-desenvolvedor.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Recupera todos os tipos de tarefas e desenvolvedores para exibição no
	 * formulário de cadastro de tarefas.
	 */
	private void mostrarCadastroTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<TipoTarefa> tiposTarefa = tipoTarefaDAO.buscarTiposTarefa();
		request.setAttribute("tiposTarefa", tiposTarefa);

		List<Desenvolvedor> desenvolvedores = desenvolvedorDAO.buscarDesenvolvedores();
		request.setAttribute("desenvolvedores", desenvolvedores);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-tarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Recupera os dados de uma tarefa específica, junto com os tipos de tarefa e
	 * desenvolvedores, e encaminha para a página de edição de tarefa.
	 */
	private void mostrarEditarTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Tarefa tarefa = tarefaDAO.buscarTarefaPorId(Long.parseLong(request.getParameter("id")));
		request.setAttribute("tarefa", tarefa);

		List<TipoTarefa> tiposTarefa = tipoTarefaDAO.buscarTiposTarefa();
		request.setAttribute("tiposTarefa", tiposTarefa);

		List<Desenvolvedor> desenvolvedores = desenvolvedorDAO.buscarDesenvolvedores();
		request.setAttribute("desenvolvedores", desenvolvedores);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-tarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Recupera os dados de um usuário específico com base no ID fornecido e
	 * encaminha para a página de edição de usuário.
	 */
	private void mostrarEditarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Usuario usuario = usuarioDAO.buscarUsuarioPorId(Long.parseLong(request.getParameter("id")));
		request.setAttribute("usuario", usuario);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-usuario.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Recupera todos os tipos de tarefa do banco de dados e encaminha para a página
	 * de exibição.
	 */
	private void visualizarTiposTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<TipoTarefa> tiposTarefa = tipoTarefaDAO.buscarTiposTarefa();
		request.setAttribute("tiposTarefa", tiposTarefa);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/visualizar-tipos-tarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Realiza a pesquisa de tipos de tarefa com base no nome informado e encaminha
	 * os resultados para a página de exibição.
	 */
	private void mostrarResultadoPesquisaTipoTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<TipoTarefa> tiposTarefa = tipoTarefaDAO.buscarTiposTarefaPorNome(request.getParameter("nome"));
		request.setAttribute("tiposTarefa", tiposTarefa);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("assets/paginas/resultado-pesquisa-tipo-tarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Realiza a pesquisa de usuários com base no nome informado e encaminha os
	 * resultados para a página de exibição.
	 */
	private void mostrarResultadoPesquisaUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Usuario> usuarios = usuarioDAO.buscarUsuariosPorNome(request.getParameter("nomePesquisa"));
		request.setAttribute("usuarios", usuarios);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/resultado-pesquisa-usuario.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Encaminha a requisição para a página de cadastro de tipos de tarefa.
	 */
	private void mostrarCadastroTipoTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-tipo-tarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Recupera os dados de um tipo de tarefa específico com base no ID fornecido e
	 * encaminha para a página de edição.
	 */
	private void mostrarEditarTipoTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TipoTarefa tipotarefa = tipoTarefaDAO.buscarTipoTarefaPorId(Long.parseLong(request.getParameter("id")));
		request.setAttribute("tipoTarefa", tipotarefa);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/editar-tipo-tarefa.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * Encaminha a requisição para a página de cadastro de desenvolvedores.
	 */
	private void mostrarCadastroDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-desenvolvedor.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTipoTarefaTemTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tipo-tarefa-tem-tarefa.jsp");
		dispatcher.forward(request, response);
	}

	// Realiza o login do usuário validando email e senha.
	private void logar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Obtém os parâmetros do formulário de login.
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		// Cria ou recupera a sessão atual.
		HttpSession sessao = request.getSession();

		// Busca o usuário no banco de dados com base no email e senha fornecidos.
		Usuario usuario = usuarioDAO.buscarUsuarioPorEmailESenha(email, senha);

		// Redireciona para a página inicial se o usuário for encontrado, caso
		// contrário, retorna para a página de login.
		if (usuario != null) {
			sessao.setAttribute("usuario", usuario);
			response.sendRedirect("home");
		} else {
			response.sendRedirect("login");
		}
	}

	// Insere um novo usuário no sistema, diferenciando entre desenvolvedores e
	// outros usuários.
	private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nivel = request.getParameter("nivel");

		// Verifica se o nível do usuário é "dev" (desenvolvedor).
		if (nivel.equals("dev")) {
			// Obtém os dados do formulário para desenvolvedor.
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			// Insere o desenvolvedor e o usuário nas tabelas correspondentes.
			desenvolvedorDAO.inserirDesenvolvedor(new Desenvolvedor(nome, email, nivel, senha));
			usuarioDAO.inserirUsuario(new Usuario(nome, email, nivel, senha));

			response.sendRedirect("login");
		} else {
			// Insere um usuário comum.
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			usuarioDAO.inserirUsuario(new Usuario(nome, email, nivel, senha));
			response.sendRedirect("login");
		}
	}

	// Atualiza os dados de um usuário, diferenciando entre desenvolvedores e outros
	// usuários.
	private void atualizarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nivel = request.getParameter("nivel");

		// Verifica se o usuário é um desenvolvedor.
		if (nivel.equals("dev")) {
			// Atualiza os dados de um desenvolvedor.
			Long id = Long.parseLong(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			desenvolvedorDAO.atualizarDesenvolvedor(new Desenvolvedor(id, nome, email, nivel, senha));
			usuarioDAO.atualizarUsuario(new Usuario(id, nome, email, nivel, senha));
			response.sendRedirect("visualizar-desenvolvedores");
		} else {
			// Atualiza os dados de um usuário comum.
			Long id = Long.parseLong(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			usuarioDAO.atualizarUsuario(new Usuario(id, nome, email, nivel, senha));
			response.sendRedirect("visualizar-usuarios");
		}
	}

	// Remove um usuário do sistema com base no ID fornecido.
	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Busca o usuário pelo ID.
		Usuario usuario = usuarioDAO.buscarUsuarioPorId(Long.parseLong(request.getParameter("id")));

		// Remove o usuário do banco de dados.
		usuarioDAO.deletarUsuario(usuario);

		response.sendRedirect("visualizar-usuarios");
	}

	// Remove um desenvolvedor do sistema, verificando se ele possui tarefas
	// atribuídas.
	private void deletarDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Busca o desenvolvedor e o usuário correspondentes pelo ID.
		Desenvolvedor desenvolvedor = desenvolvedorDAO
				.buscarDesenvolvedorPorId(Long.parseLong(request.getParameter("id")));
		Usuario usuario = usuarioDAO.buscarUsuarioPorId(Long.parseLong(request.getParameter("id")));

		// Verifica se o desenvolvedor está associado a alguma tarefa.
		List<Tarefa> tarefas = tarefaDAO.buscarTarefasComTipoTarefa();
		boolean temTarefaParaDesenvolvedor = tarefas.stream()
				.anyMatch(tarefa -> tarefa.getDesenvolvedor().getNome().equals(desenvolvedor.getNome()));

		if (temTarefaParaDesenvolvedor) {
			// Redireciona para uma página de aviso se houver tarefas associadas ao
			// desenvolvedor.
			response.sendRedirect("aviso-desenvolvedor-com-tarefa");
		} else {
			// Remove o desenvolvedor e o usuário do banco de dados.
			desenvolvedorDAO.deletarDesenvolvedor(desenvolvedor);
			usuarioDAO.deletarUsuario(usuario);
			response.sendRedirect("visualizar-desenvolvedores");
		}
	}

	// Insere uma nova tarefa no sistema associando-a a um tipo de tarefa e a um
	// desenvolvedor.
	private void inserirTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Obtém os dados do formulário para criar uma nova tarefa.
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		TipoTarefa tipoTarefa = tipoTarefaDAO.buscarTipoTarefaPorId(Long.parseLong(request.getParameter("tipoTarefa")));
		Desenvolvedor desenvolvedor = desenvolvedorDAO
				.buscarDesenvolvedorPorId(Long.parseLong(request.getParameter("Desenvolvedor")));

		// Insere a nova tarefa no banco de dados.
		tarefaDAO.inserirTarefa(new Tarefa(nome, desc, tipoTarefa, desenvolvedor));

		response.sendRedirect("home");
	}

	// Atualiza os dados de uma tarefa existente.
	private void atualizarTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Obtém os dados do formulário para atualizar a tarefa.
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		TipoTarefa tipoTarefa = tipoTarefaDAO.buscarTipoTarefaPorId(Long.parseLong(request.getParameter("tipoTarefa")));
		Desenvolvedor desenvolvedor = desenvolvedorDAO
				.buscarDesenvolvedorPorId(Long.parseLong(request.getParameter("desenvolvedor")));

		// Atualiza a tarefa no banco de dados.
		tarefaDAO.atualizarTarefa(new Tarefa(id, nome, desc, tipoTarefa, desenvolvedor));

		response.sendRedirect("home");
	}

	// Remove uma tarefa do sistema com base no ID fornecido.
	private void deletarTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Busca a tarefa pelo ID.
		Tarefa tarefa = tarefaDAO.buscarTarefaPorId(Long.parseLong(request.getParameter("id")));

		// Remove a tarefa do banco de dados.
		tarefaDAO.deletarTarefa(tarefa);

		response.sendRedirect("home");
	}

	// Insere um novo tipo de tarefa no sistema.
	private void inserirTipoTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Obtém os dados do formulário para criar um tipo de tarefa.
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");

		// Insere o tipo de tarefa no banco de dados.
		tipoTarefaDAO.inserirTipoTarefa(new TipoTarefa(nome, desc));

		response.sendRedirect("home");
	}

	// Atualiza os dados de um tipo de tarefa existente.
	private void atualizarTipoTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Obtém os dados do formulário para atualizar o tipo de tarefa.
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");

		// Atualiza o tipo de tarefa no banco de dados.
		tipoTarefaDAO.atualizarTipoTarefa(new TipoTarefa(id, nome, desc));

		response.sendRedirect("visualizar-tipos-tarefa");
	}

	// Remove um tipo de tarefa do sistema, verificando se ele está associado a
	// alguma tarefa.
	private void deletarTipoTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		// Busca o tipo de tarefa pelo ID.
		TipoTarefa tipoTarefa = tipoTarefaDAO.buscarTipoTarefaPorId(Long.parseLong(request.getParameter("id")));

		// Verifica se o tipo de tarefa está associado a alguma tarefa.
		List<Tarefa> tarefas = tarefaDAO.buscarTarefasComTipoTarefa();
		boolean temTarefaParaTipoTarefa = tarefas.stream()
				.anyMatch(tarefa -> tarefa.getTipoTarefa().getId().equals(tipoTarefa.getId()));

		if (temTarefaParaTipoTarefa) {
			// Redireciona para uma página de aviso se houver tarefas associadas ao tipo de
			// tarefa.
			response.sendRedirect("tipo-tarefa-tem-tarefa");
		} else {
			// Remove o tipo de tarefa do banco de dados.
			tipoTarefaDAO.deletarTipoTarefa(tipoTarefa);
			response.sendRedirect("visualizar-tipos-tarefa");
		}
	}
}