package it.unirc.twd.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Attrezzi;
import it.unirc.twd.beans.AttrezziDAO;
import it.unirc.twd.beans.Utente;
import it.unirc.twd.beans.UtenteDAO;

/**
 * Servlet implementation class EliminaUtente
 */
@WebServlet("/EliminaUtente")
public class EliminaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UtenteDAO uDAO = new UtenteDAO();
	AttrezziDAO aDAO = new AttrezziDAO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminaUtente() {
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
		Utente u = new Utente();
		if(uDAO.EsisteCliente(username)) {
			boolean res = uDAO.EliminaByString(username);
			System.out.println("Elimina:" + res);
				HttpSession session = request.getSession();
				session.setAttribute("stato", "utente elimina");
				Vector<Utente> list = uDAO.getAll(); //Creo il vettore degli utenti per lo show all nell'are admin
				Vector<Utente> clienti = uDAO.getAllClienti();
				Vector<Attrezzi> listaattrezzi = aDAO.getAll();
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
			session.setAttribute("stato", "errore utente non eliminato");
			Vector<Utente> list = uDAO.getAll(); //Creo il vettore degli utenti per lo show all nell'are admin
			Vector<Utente> clienti = uDAO.getAllClienti();
			Vector<Attrezzi> listaattrezzi = aDAO.getAll();
			session.setAttribute("numeroClienti", uDAO.ContaClienti());
			session.setAttribute("numeroAdmin", uDAO.ContaAdmin());
			session.setAttribute("numeroAttrezzi", aDAO.contaAttrezzi());
			session.setAttribute("lista_attrezzi", listaattrezzi);
			session.setAttribute("listautenti", list);
			session.setAttribute("listaClienti", clienti);

			response.sendRedirect("AreaRiservataAdmin.jsp");
		}
	}
}
