package it.unirc.twd.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Corsi;
import it.unirc.twd.beans.CorsiDAO;
import it.unirc.twd.beans.Dati_fisici;
import it.unirc.twd.beans.Dati_fisiciDAO;
import it.unirc.twd.beans.Iscrizioni;
import it.unirc.twd.beans.IscrizioniDAO;
import it.unirc.twd.beans.Pagamento;
import it.unirc.twd.beans.PagamentoDAO;
import it.unirc.twd.beans.Scheda_allenamento;
import it.unirc.twd.beans.Scheda_allenamentoDAO;
import it.unirc.twd.beans.Utente;
import it.unirc.twd.beans.UtenteDAO;

/**
 * Servlet implementation class CreaIscrizione
 */
@WebServlet("/CreaIscrizione")
public class CreaIscrizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IscrizioniDAO iDAO = new IscrizioniDAO();
     CorsiDAO cDAO = new CorsiDAO();
     UtenteDAO uDAO = new UtenteDAO();
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
		i.setUsername(utente.getUsername());
		i.setNomeCorso(request.getParameter("nomeCorso"));
		System.out.println(i.toString());
		if(iDAO.SalvaIscrizione(i)) {			
			session.setAttribute("stato", "aggiunta iscrizione");
			Utente u = uDAO.getUtenteByString(utente.getUsername());
			System.out.println(utente.toString());
		    Dati_fisiciDAO dfDAO = new Dati_fisiciDAO();
			Dati_fisici df = dfDAO.getDFByString(utente.getUsername());
			PagamentoDAO pDAO = new PagamentoDAO(); 
			Pagamento p = pDAO.getPagamentoByString(utente.getUsername());
			Scheda_allenamentoDAO sDAO = new Scheda_allenamentoDAO();
			Scheda_allenamento s = sDAO.getSchedaByString(utente.getUsername());
			Vector<Iscrizioni> lista_iscrizioni = iDAO.getByUtente(utente.getUsername());
			Vector<Corsi> listacorsi = cDAO.getAll();
			session.setAttribute("utente", u);
			session.setAttribute("dati_fisici", df);
			session.setAttribute("pagamento", p);
			session.setAttribute("scheda", s);
			session.setAttribute("lista_corsi", listacorsi);
			session.setAttribute("lista_iscrizioni", lista_iscrizioni);
			response.sendRedirect("AreaRiservataUtente.jsp");
		}
		else {		
			
			Utente u = uDAO.getUtenteByString(utente.getUsername());
			Vector<Iscrizioni> lista_iscrizioni = iDAO.getByUtente(utente.getUsername());
		    Dati_fisiciDAO dfDAO = new Dati_fisiciDAO();
			Dati_fisici df = dfDAO.getDFByString(utente.getUsername());
			PagamentoDAO pDAO = new PagamentoDAO(); 
			Pagamento p = pDAO.getPagamentoByString(utente.getUsername());
			Scheda_allenamentoDAO sDAO = new Scheda_allenamentoDAO();
			Scheda_allenamento s = sDAO.getSchedaByString(utente.getUsername());
			Vector<Corsi> listacorsi = cDAO.getAll();
			session.setAttribute("utente", utente);
			session.setAttribute("dati_fisici", df);
			session.setAttribute("pagamento", p);
			session.setAttribute("scheda", s);
			session.setAttribute("lista_corsi", listacorsi);
			session.setAttribute("lista_iscrizioni", lista_iscrizioni);
			session.setAttribute("stato", "errore iscrizione");
			response.sendRedirect("AreaRiservataUtente.jsp");
		}
	}

}
