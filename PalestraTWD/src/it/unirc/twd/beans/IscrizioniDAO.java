package it.unirc.twd.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twd.utils.DBManager;

public class IscrizioniDAO {
	private static Connection conn = null;
	
	public Iscrizioni getIscrizioniByUtente(Iscrizioni i) {
		String query = "SELECT nomecorso FROM Iscrizioni WHERE username=?";
		Iscrizioni res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, i.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Iscrizioni();
				res.setUsername(rs.getString("username"));
				res.setNomeCorso(rs.getString("nomecorso"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	public Iscrizioni getIscrizioniByCorso(Iscrizioni i) {
		String query = "SELECT username FROM Iscrizioni WHERE nomecorso=?";
		Iscrizioni res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, i.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Iscrizioni();
				res.setUsername(rs.getString("username"));
				res.setNomeCorso(rs.getString("nomecorso"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	public boolean SalvaIscrizione(Iscrizioni i) {
		String query = "INSERT INTO Iscrizioni VALUES (?, ?)";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, i.getUsername());
			ps.setString(2, i.getNomeCorso());
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
	public boolean EliminaIscrizioni(String username, String corso) {
		String query = "DELETE FROM Iscrizioni WHERE Username = ? and nomecorso=?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, corso);
			System.out.println(ps);
			int tmp=ps.executeUpdate();
			System.out.println("primaif");
			if(tmp==1) {
				esito=true;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return esito;
	}
	public Vector<Iscrizioni> getAll(){
		String query = "SELECT * FROM Iscrizioni";
		Vector<Iscrizioni> list = new Vector<Iscrizioni>();
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(recordToIscrizione(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return list;
	}
	
	public boolean EsisteIscrizione(String username, String nomeCorso) {
		String query = "Select * FROM Iscrizione where username = ? and nomecorso = ?";
		boolean res = false;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2,  nomeCorso);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//res.setUsername(rs.getString("username"));
				//res.setAutorita(rs.getString("autorità"));
				res=true;
				System.out.println(res);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	protected Iscrizioni recordToIscrizione(ResultSet rs) throws SQLException {
		Iscrizioni res=new Iscrizioni();
		res.setUsername(rs.getString("Username"));
		res.setNomeCorso(rs.getString("nomecorso"));
		return res;
	}

}
