package it.unirc.twd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Attrezzi;
import it.unirc.twd.beans.AttrezziDAO;

/**
 * Servlet implementation class CreaAttrezzo
 */
@WebServlet("/CreaAttrezzo")
public class CreaAttrezzo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AttrezziDAO aDAO = new AttrezziDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaAttrezzo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
        String gruppomuscolare = request.getParameter("gruppo_muscolare");
		Attrezzi a = new Attrezzi();
		a.setNome(nome);
		a.setGruppo_muscolare(gruppomuscolare);
		System.out.println(a.toString());
		boolean res = aDAO.SalvaAttrezzi(a);
		System.out.println(res);
		if(res) {
			HttpSession session = request.getSession();
			session.setAttribute("stato", "aggiunto utente");
			response.sendRedirect("AreaRiservataAdmin.jsp");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("stato", "errore aggiunta utente");
			response.sendRedirect("AreaRiservataAdmin.jsp");
		}
	}

}
