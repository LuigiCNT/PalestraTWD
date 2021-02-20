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

/**
 * Servlet implementation class InserisciDati
 */
@WebServlet("/InserisciDati")
public class InserisciDati extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Dati_fisiciDAO dDAO = new Dati_fisiciDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserisciDati() {
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
		Dati_fisici d = new Dati_fisici();
		d.setUsername(request.getParameter("username"));
		d.setAltezza(Integer.valueOf(request.getParameter("altezza")));
		d.setPeso(Integer.valueOf(request.getParameter("peso")));
		d.setPlicometria(Integer.valueOf(request.getParameter("plicometria")));
		System.out.println(d.toString());
		if(dDAO.SalvaDati_Fisici(d)) {
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
