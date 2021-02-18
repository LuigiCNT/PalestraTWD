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

/**
 * Servlet implementation class RedirectServizi
 */
@WebServlet("/RedirectServizi")
public class RedirectServizi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Vector<Attrezzi> aa = new Vector<Attrezzi>();
       AttrezziDAO aaDAO = new AttrezziDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServizi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		aa = aaDAO.getAll();
		session.setAttribute("lista_attrezzi", aa);
		response.sendRedirect("Servizi.jsp");
		
	}

}
