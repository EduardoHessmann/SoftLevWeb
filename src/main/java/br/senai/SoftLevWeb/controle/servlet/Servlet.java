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
import br.senai.SoftLevWeb.modelo.dao.tarefa.TarefaDAO;
import br.senai.SoftLevWeb.modelo.dao.tarefa.TarefaDAOImpl;
import br.senai.SoftLevWeb.modelo.dao.tipoTarefa.TipoTarefaDAO;
import br.senai.SoftLevWeb.modelo.dao.tipoTarefa.TipoTarefaDAOImpl;
import br.senai.SoftLevWeb.modelo.dao.usuario.UsuarioDAO;
import br.senai.SoftLevWeb.modelo.dao.usuario.UsuarioDAOImpl;

@WebServlet("/")
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 8840029940617992062L;

	private UsuarioDAO usuarioDAO;
	private TarefaDAO tarefaDAO;
	private TipoTarefaDAO tipoTarefaDAO;
	private DesenvolvedorDAO desenvolvedorDAO;

	public void init() {
		usuarioDAO = new UsuarioDAOImpl();

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

			case "/index":
				mostrarIndex(request, response);
				break;

			
			default:
				mostrarIndex(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
		

	}

	private void mostrarIndex(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("assets/paginas/inedx.jsp");
		dispatcher.forward(request, response);
	}
	
}