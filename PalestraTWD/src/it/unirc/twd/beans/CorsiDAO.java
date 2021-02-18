package it.unirc.twd.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twd.utils.DBManager;


public class CorsiDAO {
	private static Connection conn = null;

	public Corsi getCorsi(Corsi c) {
		String query = "Select * FROM Corsi where tipologia = ?";
		Corsi res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, c.getTipologia());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Corsi();
				res.setTipologia(rs.getString("tipologia"));
				res.setCoach(rs.getString("coach"));
				res.setDurata(rs.getInt("durata"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	public boolean SalvaSCorsi(Corsi c) {
		String query = "INSERT INTO Corsi VALUES (?, ?, ?)";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, c.getTipologia());
			ps.setString(2, c.getCoach());
			ps.setInt(3, c.getDurata());
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
	public boolean EliminaCorsi(Corsi c) {
		String query = "DELETE * FROM corsi WHERE tipologia = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, c.getTipologia());
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
	
	public boolean AggiornaCorsi(Corsi c) {
		String query = "UPDATE Corsi SET coach = ?, durata = ? WHERE tipologia = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(3, c.getTipologia());
			ps.setString(1, c.getCoach());
			ps.setInt(2, c.getDurata());
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
	public Vector<Corsi> getAll(){
		String query = "SELECT * FROM Corsi";
		Vector<Corsi> list = new Vector<Corsi>();
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(recordToCorsi(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return list;
	}

	protected Corsi recordToCorsi(ResultSet rs) throws SQLException {
		Corsi res=new Corsi();
		
		res.setTipologia(rs.getString("Tipologia"));
		res.setCoach(rs.getString("Coach"));
		res.setDurata(rs.getInt("Durata"));
		return res;

	}

}
