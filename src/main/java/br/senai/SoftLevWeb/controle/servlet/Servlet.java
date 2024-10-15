package br.senai.SoftLevWeb.controle.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.SoftLevWeb.modelo.dao.desenvolvedor.DesenvolvedorDAO;
import br.senai.SoftLevWeb.modelo.dao.desenvolvedor.DesenvolvedorDAOImpl;
import br.senai.SoftLevWeb.modelo.dao.tarefa.TarefaDAO;
import br.senai.SoftLevWeb.modelo.dao.tarefa.TarefaDAOImpl;
import br.senai.SoftLevWeb.modelo.dao.tipoTarefa.TipoTarefaDAO;
import br.senai.SoftLevWeb.modelo.dao.tipoTarefa.TipoTarefaDAOImpl;
import br.senai.SoftLevWeb.modelo.dao.usuario.UsuarioDAO;
import br.senai.SoftLevWeb.modelo.dao.usuario.UsuarioDAOImpl;
import br.senai.SoftLevWeb.modelo.entidade.desenvolvedor.Desenvolvedor;
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
				
			case "/tela-principal":
				mostrarTelaPrincipal(request, response);
				break;
				
			case "/cadastro-usuario":
				mostrarCadastroUsuario(request, response);
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

			default:
				mostrarTelaPrincipal(request, response);
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrarCadastroUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/cadastro-usuario.jsp");
		dispatcher.forward(request, response);
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
//		TipoTarefa tipoTarefa = request.getParameter("tipoTarefa");
		
//		tarefaDAO.inserirTarefa(new Tarefa(nome, desc, tipoTarefa));
		
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