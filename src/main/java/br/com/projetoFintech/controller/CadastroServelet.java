package br.com.projetoFintech.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoFintech.dao.UsuarioDAO;

/**
 * Servlet implementation class Servelet
 */
@WebServlet("/cadastro")
public class CadastroServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("aqui estamos1");
		UsuarioDAO user = new UsuarioDAO();
		String cpf = request.getParameter("cpf");
		System.out.println(request.getParameter("cpf"));
		response.getWriter().append("sucesso");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==========POST=============");
		String cpf = request.getParameter("cpf");
		System.out.println(cpf);
		System.out.println("==========POST=============");
		doGet(request, response);
	}

}
