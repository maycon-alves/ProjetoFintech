package br.com.projetoFintech.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetoFintech.Enums.TipoFaturamentoEnum;
import br.com.projetoFintech.Enums.TipoPerfilInvestidorEnum;
import br.com.projetoFintech.dao.UsuarioDAO;
import br.com.projetoFintech.model.Usuario;

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
		UsuarioDAO dao = new UsuarioDAO();
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("cpf");
		TipoPerfilInvestidorEnum perfil = TipoPerfilInvestidorEnum.CONSERVADOR;
		TipoFaturamentoEnum faturamento = TipoFaturamentoEnum.FIXO_MENSAL;
		
		Usuario user = new Usuario(cpf,nome,senha,apelido,perfil,faturamento);
		System.out.println(user.toString());
		try {
			dao.insert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("==========POST=============");
		doGet(request, response);
	}

}
