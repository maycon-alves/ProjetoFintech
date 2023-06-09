package br.com.projetoFintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoFintech.Enums.CategoriaGastoEnum;
import br.com.projetoFintech.dao.FormaPagamentoDAO;
import br.com.projetoFintech.dao.GastoDAO;
import br.com.projetoFintech.model.Gasto;

/**
 * Servlet implementation class CadastroGastoServelet
 */
@WebServlet("/cadastro-gasto")
public class CadastroGastoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroGastoServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==========GET-INICIO-CADASTRO_GASTO=============");
		HttpSession session = request.getSession();
		String cpfUsuario = (String) session.getAttribute("cpf");
		try {
			FormaPagamentoDAO dao = new FormaPagamentoDAO();
			request.setAttribute("formasPagamento", dao.getAllbyUser(cpfUsuario));
			request.getRequestDispatcher("cadastro-gasto.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("error", "erro ao recuperar formas de pagamento da base");
			request.getRequestDispatcher("cadastro-gasto.jsp").forward(request, response);
		}
		System.out.println("==========GET-FIM-CADASTRO_GASTO=============");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==========POST-INICIO-CADASTRO_GASTO=============");
		HttpSession session = request.getSession();

		Gasto gasto = new Gasto();

		gasto.setValorGastoString(request.getParameter("valorGasto"));
		gasto.setDescricaoGasto(request.getParameter("descricaoGasto"));
		gasto.setDataGasto(request.getParameter("dataGasto"));
		gasto.setTipoGasto(identificaTipoGasto(request));
		gasto.setCategoriaGasto(identificaCategoriaGasto(request));
		gasto.setCpfUsuario((String) session.getAttribute("cpf"));
		gasto.setFormaPgtoId(request.getParameter("idFormaPagamento"));
		
		System.out.println(gasto.toString());
		
		try {
			GastoDAO dao = new GastoDAO();
			dao.insert(gasto);
			request.setAttribute("message", "Gasto cadastrado com sucesso!");
			request.getRequestDispatcher("home").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "erro ao recuperar formas de pagamento da base");
			request.getRequestDispatcher("home").forward(request, response);
		}
		
		System.out.println("==========POST-FIM-CADASTRO_GASTO=============");
	}

	private CategoriaGastoEnum identificaCategoriaGasto(HttpServletRequest request) {
		CategoriaGastoEnum categoria = null;

		if (request.getParameter("ALIMENTACAO") != null) {
			categoria = CategoriaGastoEnum.ALIMENTACAO;
		} else if (request.getParameter("SAUDE") != null) {
			categoria = CategoriaGastoEnum.SAUDE;
		} else if (request.getParameter("LAZER") != null) {
			categoria = CategoriaGastoEnum.LAZER;
		} else if (request.getParameter("IMPULSO") != null) {
			categoria = CategoriaGastoEnum.IMPULSO;
		} else if (request.getParameter("DESPESA_FIXA") != null) {
			categoria = CategoriaGastoEnum.DESPESA_FIXA;
		} else {
			categoria = CategoriaGastoEnum.IMPREVISTO;
		}
		return categoria;
	}
	
	private String identificaTipoGasto(HttpServletRequest request) {
		if(request.getParameter("FIXO") != null) {
			return "Fixo";
		}else {
			return "Mensal";
		}
	}
}
