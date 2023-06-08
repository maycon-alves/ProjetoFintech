package br.com.projetoFintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoFintech.dao.UsuarioDAO;
import br.com.projetoFintech.model.Usuario;

/**
 * Servlet implementation class LogginServelet
 */
@WebServlet("/login")
public class LogginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==========GET-LOGIN-INICIO==========");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		System.out.println("==========GET-LOGIN-FIM=============");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==========POST-LOGIN-INICIO=======");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		try {
			UsuarioDAO dao = new UsuarioDAO();
			Usuario user = dao.selectUsuarioById(cpf);
			String senhaBanco = user.getSenha();
			if (senhaBanco.equals(senha)) {
				HttpSession session = request.getSession();
				session.setAttribute("apelido", user.getApelidoUsuario());
				session.setAttribute("cpf", user.getCpf());
				request.getRequestDispatcher("home").forward(request, response);
			}else {
				request.setAttribute("error", "Senha incorreta");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", e);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		System.out.println("==========POST-LOGIN-FIM==========");
	}

}
