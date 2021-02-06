package it.unirc.twd.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Utente;
import it.unirc.twd.beans.UtenteDAO;

/**
 * Servlet implementation class CreaUtente
 */
@WebServlet("/CreaUtente")
public class CreaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UtenteDAO uDAO = new UtenteDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreaUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		Utente u = new Utente();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setAutorita(request.getParameter("autorita"));
		u.setNome(request.getParameter("nome"));
		u.setCognome(request.getParameter("cognome"));
		System.out.println(u.toString());
		if(uDAO.SalvaUtente(u)) {
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
