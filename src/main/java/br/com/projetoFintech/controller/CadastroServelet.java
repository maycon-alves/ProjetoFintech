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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("==========GET-INICIO=============");
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		System.out.println("==========GET-FIM=============");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==========POST=============");
		String cpf = request.getParameter("cpf");
		String nome = request.getParameter("nome");
		String apelido = request.getParameter("apelido");
		String senha = request.getParameter("cpf");
		String senhaConfirma = request.getParameter("confirmarSenha");
		TipoPerfilInvestidorEnum perfil = identificaPerfil(request);
		TipoFaturamentoEnum faturamento = identificaFaturamento(request);
		
		if (senha.equalsIgnoreCase(senhaConfirma)) {
			
			Usuario user = new Usuario(cpf, nome, senha, apelido, perfil, faturamento);
			System.out.println(user.toString());
			try {
				UsuarioDAO dao = new UsuarioDAO();
				dao.insert(user);
				request.setAttribute("message", "Usuario cadastrado com sucesso");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				e.printStackTrace();
				request.setAttribute("error", "erro ao inserir usuario no banco");
				request.getRequestDispatcher("cadastro.jsp").forward(request, response);
			}	
		}else {
			request.setAttribute("error", "Confirmacao de senha incorreta");
			request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		}
		System.out.println("==========POST=============");
	}

	private TipoFaturamentoEnum identificaFaturamento(HttpServletRequest request) {
		TipoFaturamentoEnum faturamento = null;
		if (request.getParameter("fs") != null) {
			faturamento = TipoFaturamentoEnum.FIXO_SEMANAL;
		} else if (request.getParameter("fm") != null) {
			faturamento = TipoFaturamentoEnum.FIXO_MENSAL;
		} else if (request.getParameter("fa") != null) {
			faturamento = TipoFaturamentoEnum.FIXO_ANUAL;
		} else if (request.getParameter("vr") != null) {
			faturamento = TipoFaturamentoEnum.VARIAVEL;
		} else if (request.getParameter("mt") != null) {
			faturamento = TipoFaturamentoEnum.MISTO;
		} else {
			faturamento = TipoFaturamentoEnum.NAO_INFORMADO;
		}
		return faturamento;
	}

	private TipoPerfilInvestidorEnum identificaPerfil(HttpServletRequest request) {
		TipoPerfilInvestidorEnum perfil = null;

		if (request.getParameter("experienciaSim") != null) {
			if (request.getParameter("altoRiscoSim") != null) {
				perfil = TipoPerfilInvestidorEnum.EXPERIENTE;
			} else {
				if (request.getParameter("altoRiscoNao") != null
						|| (request.getParameter("assumeRisco") != null && request.getParameter("3-5") != null)) {
					perfil = TipoPerfilInvestidorEnum.MODERADO;
				}
			}
		} else {
			perfil = TipoPerfilInvestidorEnum.CONSERVADOR;

		}

		return perfil;
	}

}
