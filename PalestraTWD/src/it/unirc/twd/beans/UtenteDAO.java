package it.unirc.twd.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


import it.unirc.twd.utils.DBManager;

public class UtenteDAO {
	private static Connection conn = null;

	public Utente getUtente(Utente ut) {
		String query = "Select * FROM Utente where username = ?";
		Utente res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, ut.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Utente();
				res.setUsername(rs.getString("username"));
				res.setPassword(rs.getString("password"));
				res.setAutorita(rs.getString("autorità"));
				res.setNome(rs.getString("nome"));
				res.setCognome(rs.getString("cognome"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	public boolean SalvaUtente(Utente ut) {
		String query = "INSERT INTO Utente VALUES (?, ?, ?, ?, ?)";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ut.getUsername());
			ps.setString(2, ut.getPassword());
			ps.setString(3, ut.getAutorita());
			ps.setString(4, ut.getNome());
			ps.setString(5,  ut.getCognome());
			int tmp=ps.executeUpdate();
			if(tmp==1) {
				esito=true;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	public boolean EliminaUtente(Utente ut) {
		String query = "DELETE * FROM Utente WHERE Username = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ut.getUsername());
			int tmp=ps.executeUpdate();
			if(tmp==1) {
				esito=true;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	public boolean AggiornaUtente(Utente ut) {
		String query = "UPDATE Utente SET Password = ?, autorità = ?, nome = ?, cognome = ?  WHERE Username = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ut.getPassword());
			ps.setString(2, ut.getAutorita());
			ps.setString(3, ut.getUsername());
			ps.setString(4,  ut.getNome());
			ps.setString(5,  ut.getCognome());
			int tmp=ps.executeUpdate();
			if(tmp==1) {
				esito=true;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}

	public Vector<Utente> getAll(){
		String query = "SELECT * FROM Utente";
		Vector<Utente> list = new Vector<Utente>();
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(recordToUtente(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return list;
	}

	protected Utente recordToUtente(ResultSet rs) throws SQLException {
		Utente res=new Utente();
		res.setUsername(rs.getString("Username"));
		res.setPassword(rs.getString("Password"));
		res.setAutorita(rs.getString("Autorità"));
		res.setNome(rs.getString("Nome"));
		res.setCognome(rs.getString("Cognome"));
		return res;

	}
	
	
	public Utente completaUtente(Utente u) {
		String query = "SELECT * FROM hr.Utente WHERE Username = ? AND Password = ?";
		Utente res = new Utente();
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("Ci sono1");
			ps.setString(1, u.getUsername());
			System.out.println("Ci sono2");
			ps.setString(2, u.getPassword());
			System.out.println("Ci sono3");
			ResultSet rs = ps.executeQuery();
			System.out.println("Ci sono4");
			System.out.println("rs=" + rs.toString());
			if(rs.next()) {
				res=recordToUtente(rs);
				System.out.println("Ci sono5");
				System.out.println("res=" + res.toString());
			}
		}
			catch
			(SQLException e) {
					e.printStackTrace();
			}
		DBManager.closeConnection();
		return res;
		
	}
	
	
	
	public boolean login(Utente u) {
		String query="SELECT * FROM hr.Utente WHERE Username = ? AND Password = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		System.out.println("Sto qui");
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			System.out.println(ps);
			int tmp=ps.executeUpdate();
			if(tmp==1) {
				esito=true;
				System.out.println(esito);
			}
			System.out.println("Dopo if" + esito);
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		System.out.println(esito);
		return esito;
	}
	
	public boolean LoginUtente(Utente utente) {
		boolean esito=false;
		String query="SELECT * FROM utente where username= ? and password = ?";
		PreparedStatement ps;
		Connection conn=DBManager.startConnection();
		System.out.println(conn);
		try {
		ps = conn.prepareStatement(query);
		
		ps.setString(1, utente.getUsername() );
		
		ps.setString(2, utente.getPassword() );
		int tmp=ps.executeUpdate();
		if (tmp==1)
		esito=true;
		} catch (SQLException e) {
		e.printStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
}
