package it.unirc.twd.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twd.utils.DBManager;


public class Dati_fisiciDAO {
	private static Connection conn = null;

	public Dati_fisici getDati_fisici(Dati_fisici da) {
		String query = "Select * FROM Dati_fisici where username = ?";
		Dati_fisici res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, da.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Dati_fisici();
				res.setUsername(rs.getString("username"));
				res.setAltezza(rs.getDouble("Altezza"));
				res.setPeso(rs.getDouble("Peso"));
				res.setPlicometria(rs.getDouble("Plicometria"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	public Dati_fisici getDFByString(String da) {
		String query = "Select * FROM Dati_fisici where username = ?";
		Dati_fisici res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, da);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Dati_fisici();
				res.setUsername(rs.getString("username"));
				res.setAltezza(rs.getDouble("Altezza"));
				res.setPeso(rs.getDouble("Peso"));
				res.setPlicometria(rs.getDouble("Plicometria"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	
	
	public boolean SalvaDati_Fisici(Dati_fisici da) {
		String query = "INSERT INTO Username VALUES (?, ?, ?)";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, da.getAltezza());
			ps.setDouble(2, da.getPeso());
			ps.setDouble(3, da.getPlicometria());
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
	public boolean EliminaDati_fisici(Dati_fisici da) {
		String query = "DELETE * FROM Dati_fisici WHERE Username = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, da.getUsername());
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
	public boolean AggiornaDati_fisici(Dati_fisici da) {
		String query = "UPDATE Dati_fisici SET altezza = ?, peso = ?, plicometria = ? WHERE Username = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, da.getAltezza());
			ps.setDouble(2, da.getPeso());
			ps.setDouble(3, da.getPlicometria());
			ps.setString(4, da.getUsername());
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

	public Vector<Dati_fisici> getAll(){
		String query = "SELECT * FROM Dati_fisici";
		Vector<Dati_fisici> list = new Vector<Dati_fisici>();
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(recordToDati_fisici(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return list;
	}

	protected Dati_fisici recordToDati_fisici(ResultSet rs) throws SQLException {
		Dati_fisici res=new Dati_fisici();
		res.setUsername(rs.getString("Username"));
		res.setAltezza(rs.getDouble("altezza"));
		res.setPeso(rs.getDouble("peso"));
		res.setPlicometria(rs.getDouble("plicometria"));
		return res;

	}
}
