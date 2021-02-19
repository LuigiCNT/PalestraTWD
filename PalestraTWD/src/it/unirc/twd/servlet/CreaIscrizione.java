package it.unirc.twd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Iscrizioni;
import it.unirc.twd.beans.IscrizioniDAO;
import it.unirc.twd.beans.Utente;

/**
 * Servlet implementation class CreaIscrizione
 */
@WebServlet("/CreaIscrizione")
public class CreaIscrizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IscrizioniDAO iDAO = new IscrizioniDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaIscrizione() {
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
		doGet(request, response);
		HttpSession session = request.getSession();
		Iscrizioni i = new Iscrizioni();
		System.out.println(i.toString());
		Utente utente = new Utente();
		Utente comp = new Utente();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		 for (Cookie cookie : cookies) {
		   if (cookie.getName().equals("CookieUsername")) {
		     utente.setUsername(cookie.getValue());
		     comp.setUsername(cookie.getValue());
		    }
		  }
		}
		i.setUsername(request.getParameter("CookieUsername"));
		i.setNomeCorso(request.getParameter("nomeCorso"));
		System.out.println(i.toString());
		if(iDAO.SalvaIscrizione(i)) {			
			session.setAttribute("stato", "aggiunto utente");
		    response.sendRedirect("AreaRiservataAdmin.jsp");
		   
		}
		else {		
			session.setAttribute("stato", "errore aggiunta utente");
			response.sendRedirect("AreaRiservataAdmin.jsp");
		}
	}

}
