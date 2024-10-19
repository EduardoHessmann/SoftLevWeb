package br.senai.SoftLevWeb.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;
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

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 8840029940617992062L;

	private UsuarioDAO usuarioDAO;
	private TarefaDAO tarefaDAO;
	private TipoTarefaDAO tipoTarefaDAO;
	private DesenvolvedorDAO desenvolvedorDAO;

	public void init() {
		usuarioDAO = new UsuarioDAOImpl();
		desenvolvedorDAO = new DesenvolvedorDAOImpl();
		tarefaDAO = new TarefaDAOImpl();
		tipoTarefaDAO = new TipoTarefaDAOImpl();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {

			switch (action) {

			case "/login":
				mostrarLogin(request, response);
				break;

			case "/logar":
				logar(request, response);
				break;

			case "/tela-principal":
				mostrarTelaPrincipal(request, response);
				break;

			case "/cadastro-usuario":
				mostrarCadastroUsuario(request, response);
				break;
				
			case "/cadastro-tarefa":
				mostrarCadastroTarefa(request, response);
				break;
				
			case "/cadastro-tipo-tarefa":
				mostrarCadastroTipoTarefa(request, response);
				break;
				
			case "/cadastro-desenvolvedor":
				mostrarCadastroDesenvolvedor(request, response);
				break;

			case "/inserir-usuario":
				inserirUsuario(request, response);
				break;

			case "/inserir-desenvolvedor":
				inserirDesenvolvedor(request, response);
				break;

			case "/inserir-tarefa":
				inserirTarefa(request, response);
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

	private void mostrarLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarTelaPrincipal(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/tela-principal.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrarCadastroUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarCadastroTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<TipoTarefa> tiposTarefa = tipoTarefaDAO.buscarTiposTarefa();
		request.setAttribute("tiposTarefa", tiposTarefa);

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-tarefa.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarCadastroTipoTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-tipo-tarefa.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarCadastroDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-desenvolvedor.jsp");
		dispatcher.forward(request, response);
	}

	private void logar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		HttpSession sessao = request.getSession();
		Usuario usuario = usuarioDAO.buscarUsuarioPorEmailESenha(email, senha);

		if (usuario != null) {
			sessao.setAttribute("usuario", usuario);
			response.sendRedirect("tela-principal");
		} else {
			response.sendRedirect("login");
		}

	}

	private void inserirUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		usuarioDAO.inserirUsuario(new Usuario(nome, email, senha));

		response.sendRedirect("login");

	}

	private void inserirTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		TipoTarefa tipoTarefa = tipoTarefaDAO.buscarTipoTarefaPorId(Long.parseLong(request.getParameter("id")));

		tarefaDAO.inserirTarefa(new Tarefa(nome, desc, tipoTarefa));

		response.sendRedirect("tela-principal");

	}
	
	private void inserirTipoTarefa(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String desc = request.getParameter("desc");
		
		tipoTarefaDAO.inserirTipoTarefa(new TipoTarefa(nome, desc));
		
		response.sendRedirect("tela-principal");

	}

	private void inserirDesenvolvedor(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		desenvolvedorDAO.inserirDesenvolvedor(new Desenvolvedor(nome, email, senha));

		response.sendRedirect("login");

	}

}