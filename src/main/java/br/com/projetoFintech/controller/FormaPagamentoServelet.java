package br.com.projetoFintech.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projetoFintech.dao.FormaPagamentoDAO;
import br.com.projetoFintech.model.FormaPagamentoModel;

/**
 * Servlet implementation class FormaPagamentoServelet
 */
@WebServlet("/cadastro-formaPagamento")
public class FormaPagamentoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormaPagamentoServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==========GET-INICIO-FORMA_PAGAMENTO=============");
		request.getRequestDispatcher("cadastro-formaPagamento.jsp").forward(request, response);
		System.out.println("==========GET-FIM-FORMA_PAGAMENTO=============");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("==========POST-INICIO-FORMA_PAGAMENTO=============");
		
		String apelidoFormaPagamento = request.getParameter("apelidoFormaPagamento");
		String tipoFormaPagmento = request.getParameter("tipoFormaPagmento");
		String dataVencimentoFatura = request.getParameter("dataVencimentoFatura");
		String dataAberturaFatura = request.getParameter("dataAberturaFatura");
		
		FormaPagamentoModel formaPgto = new FormaPagamentoModel(apelidoFormaPagamento,tipoFormaPagmento,dataVencimentoFatura,dataAberturaFatura);;
		
		HttpSession session = request.getSession();	
		String user = (String) session.getAttribute("cpf");
		
		try {
			System.out.println("olha o user da session" + user);
			FormaPagamentoDAO dao = new FormaPagamentoDAO();
			dao.insert(formaPgto, user);
			request.setAttribute("message", "Forma de pagamento cadastrada com sucesso!");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
			request.setAttribute("error", "erro ao inserir forma de pagamento no banco");
			request.getRequestDispatcher("cadastro-formaPagamento.jsp").forward(request, response);
		}	
		System.out.println("==========POST-FIM-FORMA_PAGAMENTO=============");
	}

}
