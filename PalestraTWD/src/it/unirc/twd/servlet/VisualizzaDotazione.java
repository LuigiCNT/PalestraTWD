package it.unirc.twd.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.CorsiDAO;
import it.unirc.twd.beans.Dotazione;
import it.unirc.twd.beans.DotazioneDAO;

/**
 * Servlet implementation class VisualizzaDotazione
 */
@WebServlet("/VisualizzaDotazione")
public class VisualizzaDotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DotazioneDAO dDAO = new DotazioneDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaDotazione() {
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
		String nomeCorso = request.getParameter("nomeCorso");
		Vector<Dotazione> d = dDAO.getByCorso(nomeCorso);
		if(d.isEmpty()) {
			HttpSession session = request.getSession();
			session.setAttribute("statoric", "vettore dot vuoto");
			response.sendRedirect("RisultatoRicerca.jsp");
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("statoric", "ricerca dot per corso");
			session.setAttribute("nomecorso", nomeCorso);
			session.setAttribute("vettore dot", d);
			response.sendRedirect("RisultatoRicerca.jsp");
		}
		
	}

}
