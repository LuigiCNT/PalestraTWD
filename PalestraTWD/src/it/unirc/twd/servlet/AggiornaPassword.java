package it.unirc.twd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Utente;
import it.unirc.twd.beans.UtenteDAO;

/**
 * Servlet implementation class AggiornaPassword
 */
@WebServlet("/AggiornaPassword")
public class AggiornaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 UtenteDAO uDAO = new UtenteDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiornaPassword() {
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
		String passwordVecchia = request.getParameter("vecchia");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
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
		comp = uDAO.getUtenteByString(comp.getUsername());
		if(passwordVecchia.equals(comp.getPassword()) && password1.equals(password2)) {
			utente.setPassword(password2);
			System.out.println("dopo set password (if) = " + utente.toString() );
			if(uDAO.AggiornaPassword(utente)) {
				PrintWriter out = response.getWriter();
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("CookiePassword")) {
						cookie.setValue(utente.getPassword().trim());
					}
				}
			    session = request.getSession();
			    out.println("<script type=\"text/javascript\">");
				out.println("alert('Password cambiata con successo, rieffettua il login');");
				out.println("location='index.html';");
				out.println("</script>"); 
			}
			else {
				session.setAttribute("stato", "errore aggiunta utente");
				response.sendRedirect("AreaRiservataUtente.jsp");
			}
		}
		else {
			PrintWriter out = response.getWriter();
			 session = request.getSession();out.println("<script type=\"text/javascript\">");
			out.println("location='index.html';");
			out.println("alert('Ricontrolla le Password');");
			out.println("</script>"); 
		}
		System.out.println(utente.toString());
		
	}

}
