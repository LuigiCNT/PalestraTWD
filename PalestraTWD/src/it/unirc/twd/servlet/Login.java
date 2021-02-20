package it.unirc.twd.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unirc.twd.beans.Attrezzi;
import it.unirc.twd.beans.AttrezziDAO;
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO uDAO = new UtenteDAO();
	private AttrezziDAO aDAO = new AttrezziDAO();
	private IscrizioniDAO iDAO = new IscrizioniDAO();
	private CorsiDAO cDAO = new CorsiDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username="+username + " " + "password=" + password);
		Utente utente = new Utente();
		utente.setUsername(username);
		utente.setPassword(password);
		System.out.println(utente.toString());
		utente = uDAO.completaUtente(utente);
		System.out.println(utente.toString());

		if (uDAO.LoginUtente(utente)) {
			HttpSession session = request.getSession();

			//if (request.getParameter("rememberMe") !=null){
				//String remember = request.getParameter("rememberMe");
				//String tempo = request.getParameter("tempo");
				//System.out.println("tempo : " + tempo);
				//System.out.println("rememberMe : " + remember);	
				//int ora = 0;
				Cookie CookieUsername = new Cookie("CookieUsername", username.trim());
				Cookie CookiePassword = new Cookie("CookiePassword", password.trim());
				/*if(tempo=="24ore") {
					ora=60*60*24;
					//CookieUsername.setMaxAge(60*60*24);
					//CookiePassword.setMaxAge(60*60*24);					
				}
				else if(tempo=="12ore") {
					ora=60*60*12;
					//CookieUsername.setMaxAge(60*60*12);
					//CookiePassword.setMaxAge(60*60*12);					
				}
				else if(tempo=="48ore"){
					ora=60*60*24*2;
					//CookieUsername.setMaxAge(60*60*24*2);
					//CookiePassword.setMaxAge(60*60*24*2);				
				}*/
				CookieUsername.setMaxAge(60*60*24*2);
				CookiePassword.setMaxAge(60*60*24*2);	
				response.addCookie(CookieUsername);
				response.addCookie(CookiePassword);
				System.out.println("Cookie:" + CookieUsername.getMaxAge());
			//}

			if(utente.getAutorita().equals("Cliente")) {
				session.setAttribute("username",username);
				session.setAttribute("successo", false);
				Vector<Iscrizioni> lista_iscrizioni = iDAO.getByUtente(utente.getUsername());
				Dati_fisiciDAO dfDAO = new Dati_fisiciDAO();
				Dati_fisici df = dfDAO.getDFByString(utente.getUsername());
				PagamentoDAO pDAO = new PagamentoDAO(); 
				Pagamento p = pDAO.getPagamentoByString(utente.getUsername());
				Scheda_allenamentoDAO sDAO = new Scheda_allenamentoDAO();
				Scheda_allenamento s = sDAO.getSchedaByString(utente.getUsername());
				Vector<Corsi> listacorsi = cDAO.getAll();
				session.setAttribute("lista_iscrizioni", lista_iscrizioni);
				session.setAttribute("dati_fisici", df);
				session.setAttribute("utente", utente);
				session.setAttribute("pagamento", p);
				session.setAttribute("scheda", s);
				session.setAttribute("lista_corsi", listacorsi);
				System.out.println("Data: " + s.getDurata());
				response.sendRedirect("AreaRiservataUtente.jsp");
			}  
			else if(utente.getAutorita().equals("Admin")) {
				//HttpSession session = request.getSession();
				session.setAttribute("username",username);
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
				session.setAttribute("stato", "login");
				response.sendRedirect("AreaRiservataAdmin.jsp");
			}
		}
		else {
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			out.println("<script type=\"text/javascript\">");
			out.println("location='index.html';");
			out.println("alert('User or password incorrect');");
			out.println("</script>"); 
		}
	}


	private Utente checkCookie(HttpServletRequest request) {
		Cookie[] cookies=request.getCookies();
		Utente utente = null;
		if (cookies != null) {
			String username = "", password="";
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("CookieUsername")) {
					username = cookie.getValue();
				}
				if(cookie.getName().equals("CookiePassword")){
					password = cookie.getValue();
				}   
			}
			if(!username.isEmpty() && !password.isEmpty())
				utente = new Utente(username, password,"", "", "", 0);
		}
		return utente;

	}
}
