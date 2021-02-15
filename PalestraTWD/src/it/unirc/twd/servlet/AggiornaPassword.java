package it.unirc.twd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("username");
		String passwordVecchia = request.getParameter("vecchia");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		Utente utente = new Utente();
		utente.setUsername(username);
		if(passwordVecchia == utente.getPassword() && password1 == password2) {
			utente.setPassword(password2);
			if(uDAO.AggiornaPassword(utente)) {
				HttpSession session = request.getSession();	
				session.setAttribute("stato", "aggiunto utente");
			    response.sendRedirect("AreaRiservataUtente.jsp");
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("stato", "errore aggiunta utente");
				response.sendRedirect("AreaRiservataUtente.jsp");
			}
		}
		else {
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();out.println("<script type=\"text/javascript\">");
			out.println("location='index.html';");
			out.println("alert('Ricontrolla le Password');");
			out.println("</script>"); 
		}
		System.out.println(utente.toString());
		
	}

}
