package it.unirc.twd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Scheda_allenamento;
import it.unirc.twd.beans.Scheda_allenamentoDAO;

/**
 * Servlet implementation class AggiungiScheda
 */
@WebServlet("/AggiungiScheda")
public class AggiungiScheda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Scheda_allenamentoDAO sDAO = new Scheda_allenamentoDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiScheda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String tipologia = request.getParameter("tipologia");
		int durata = Integer.valueOf(request.getParameter("durata"));
		String link = request.getParameter("link");
		Scheda_allenamento s = new Scheda_allenamento();
		s.setUsername(username);
		s.setTipologia(tipologia);
		s.setDurata(durata);
		s.setLink(link);
		System.out.println(s.toString());
		boolean res = sDAO.SalvaScheda_allenamento(s);
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
