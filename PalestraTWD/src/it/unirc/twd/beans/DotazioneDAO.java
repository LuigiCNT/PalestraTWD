package it.unirc.twd.beans;

import java.sql.PreparedStatement;

import it.unirc.twd.utils.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twd.utils.DBManager;


public class DotazioneDAO {
	private static Connection conn = null;
	
	public Dotazione getDotazioneByAttrezzo(Dotazione d) {
		String query = "select*from dotazione where attrezzo = ?";
		Dotazione res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, d.getAttrezzo());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Dotazione();
				res.setAttrezzo(rs.getString("attrezzo"));
				res.setNomeCorso(rs.getString("nomecorso"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	public Dotazione getDotazioneByCorso(Dotazione d) {
		String query = "select*from dotazione where nomecorso = ?";
		Dotazione res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, d.getNomeCorso());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Dotazione();
				res.setAttrezzo(rs.getString("attrezzo"));
				res.setNomeCorso(rs.getString("nomecorso"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	

	public boolean SalvaDotazione(Dotazione d) {
		String query = "INSERT INTO Dotazione VALUES (?, ?)";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, d.getAttrezzo());
			ps.setString(2, d.getNomeCorso());
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
	
	public boolean EliminaDotazione(String attrezzo, String corso) {
		String query = "DELETE FROM Dotazione WHERE attrezzo = ? and nomecorso=?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, attrezzo);
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
	
	public Vector<Dotazione> getAll(){
		String query = "SELECT * FROM Dotazione";
		Vector<Dotazione> list = new Vector<Dotazione>();
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(recordToDotazione(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return list;
	}
	
	public Vector<Dotazione> getByCorso(String s){
		String query = "SELECT * FROM Dotazione WHERE CORSO = ?";
		Vector<Dotazione> list = new Vector<Dotazione>();
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, s);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(recordToDotazione(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return list;
	}
	

	public boolean EsisteDotazione(String attrezzo, String nomeCorso) {
		String query = "Select * FROM Dotazione where attrezzo = ? and nomecorso = ?";
		boolean res = false;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, attrezzo);
			ps.setString(2,  nomeCorso);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				res=true;
				System.out.println(res);
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	protected Dotazione recordToDotazione(ResultSet rs) throws SQLException {
		Dotazione res=new Dotazione();
		res.setAttrezzo(rs.getString("attrezzo"));
		res.setNomeCorso(rs.getString("corso"));
		return res;
	}
}
