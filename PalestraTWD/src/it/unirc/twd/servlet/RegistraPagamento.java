package it.unirc.twd.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Pagamento;
import it.unirc.twd.beans.PagamentoDAO;

/**
 * Servlet implementation class RegistraPagamento
 */
@WebServlet("/RegistraPagamento")
public class RegistraPagamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PagamentoDAO pDAO = new PagamentoDAO();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistraPagamento() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		Pagamento p = new Pagamento();
		String data = request.getParameter("data");
		System.out.println(data);
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date startDate = null;
		try {
			startDate = sdf.parse(startDateStr);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		*/
		p.setUsername(request.getParameter("username"));	
		p.setData(Date.valueOf("data"));
		p.setMetodo(request.getParameter("metodo"));
		p.setImporto(Integer.valueOf(request.getParameter("importo")));
		System.out.println(p.toString());
		
		
		
		if(pDAO.RegistraPagamento(p)) {
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

