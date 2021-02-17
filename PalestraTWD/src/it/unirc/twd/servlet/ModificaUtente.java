package it.unirc.twd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Dati_fisici;
import it.unirc.twd.beans.Dati_fisiciDAO;
import it.unirc.twd.beans.Utente;
import it.unirc.twd.beans.UtenteDAO;

/**
 * Servlet implementation class ModificaUtente
 */
@WebServlet("/ModificaUtente")
public class ModificaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dati_fisiciDAO daDAO = new Dati_fisiciDAO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaUtente() {
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
		String username = request.getParameter("username");
		UtenteDAO uDAO= new UtenteDAO();
		if(uDAO.EsisteCliente(username)) {
			Dati_fisici da = new Dati_fisici();

			da.setUsername(request.getParameter("username"));
			da.setAltezza( Double.parseDouble(request.getParameter("altezza")));
			da.setPeso( Double.parseDouble(request.getParameter("peso")));
			da.setPlicometria( Double.parseDouble(request.getParameter("plicometria")));
			System.out.println(da.toString());
			if(daDAO.AggiornaDati_fisici(da)) {
				HttpSession session = request.getSession();
				session.setAttribute("stato", "utente aggiornato");
				//session.setAttribute("username", );
				response.sendRedirect("AreaRiservataAdmin.jsp");

			}
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("stato", "errore utente non aggiornato");
			response.sendRedirect("AreaRiservataAdmin.jsp");
		}
	}

}

