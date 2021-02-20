package it.unirc.twd.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Attrezzi;
import it.unirc.twd.beans.AttrezziDAO;
import it.unirc.twd.beans.Iscrizioni;
import it.unirc.twd.beans.IscrizioniDAO;
import it.unirc.twd.beans.Utente;
import it.unirc.twd.beans.UtenteDAO;

/**
 * Servlet implementation class CreaUtente
 */
@WebServlet("/CreaUtente")
public class CreaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UtenteDAO uDAO = new UtenteDAO();
       AttrezziDAO aDAO = new AttrezziDAO();
       IscrizioniDAO iDAO = new IscrizioniDAO();
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
		u.setAnno(Integer.valueOf(request.getParameter("anno")));
		System.out.println(u.toString());
		if(uDAO.SalvaUtente(u)) {
			HttpSession session = request.getSession();
			session.setAttribute("stato", "aggiunto utente");
			Vector<Utente> list = uDAO.getAll(); //Creo il vettore degli utenti per lo show all nell'are admin
			Vector<Utente> clienti = uDAO.getAllClienti();
			Vector<Attrezzi> listaattrezzi = aDAO.getAll();
			Vector<Iscrizioni> listaIscrizioni = iDAO.getAll();
			session.setAttribute("lista_iscrizioni", listaIscrizioni);
			session.setAttribute("numeroClienti", uDAO.ContaClienti());
			session.setAttribute("numeroAdmin", uDAO.ContaAdmin());
			session.setAttribute("numeroAttrezzi", aDAO.contaAttrezzi());
			session.setAttribute("lista_attrezzi", listaattrezzi);
			session.setAttribute("listautenti", list);
			session.setAttribute("listaClienti", clienti);
		    response.sendRedirect("AreaRiservataAdmin.jsp");
		   
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("stato", "errore aggiunta utente");
			session.setAttribute("numeroClienti", uDAO.ContaClienti());
			session.setAttribute("numeroAdmin", uDAO.ContaAdmin());
			response.sendRedirect("AreaRiservataAdmin.jsp");
		}
	}

}
