package br.com.projetoFintech.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoFintech.dao.GastoDAO;
import br.com.projetoFintech.model.Gasto;

/**
 * Servlet implementation class HomeServelet
 */
@WebServlet("/home")
public class HomeServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==========GET-INICIO-HOME=============");
		HttpSession session = request.getSession();	
		String userId = (String) session.getAttribute("cpf");
		try {
			System.out.println(userId);
			GastoDAO gasto = new GastoDAO();
			request.setAttribute("gastos", gasto.getAllbyId(userId));
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", "erro ao recuperar gastos na base");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		System.out.println("==========GET-FIM-HOME=============");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
