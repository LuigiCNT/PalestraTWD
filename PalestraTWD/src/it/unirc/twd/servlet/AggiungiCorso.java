package it.unirc.twd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Corsi;
import it.unirc.twd.beans.CorsiDAO;
import it.unirc.twd.beans.Scheda_allenamento;

/**
 * Servlet implementation class AggiungiCorso
 */
@WebServlet("/AggiungiCorso")
public class AggiungiCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CorsiDAO cDAO = new CorsiDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiCorso() {
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
		String tipologia = request.getParameter("tipologia");
		
		int durata = Integer.valueOf(request.getParameter("durata"));
		String coach = request.getParameter("coach");
		Corsi c = new Corsi();
		
		c.setTipologia(tipologia);
		c.setDurata(durata);
		c.setCoach(coach);
		System.out.println( c.toString());
		boolean res = cDAO.SalvaSCorsi(c);
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
