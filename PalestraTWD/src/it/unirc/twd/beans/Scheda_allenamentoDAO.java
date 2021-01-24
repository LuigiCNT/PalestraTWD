package it.unirc.twd.beans;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twd.utils.DBManager;

public class Scheda_allenamentoDAO {
	private static Connection conn = null;

	public Scheda_allenamento getScheda_allenamento(Scheda_allenamento sa) {
		String query = "Select * FROM Scheda_allenamento where username = ?";
		Scheda_allenamento res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, sa.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Scheda_allenamento();
				res.setUsername(rs.getString("username"));
				res.setTipologia(rs.getString("Tipologia"));
				res.setData(rs.getDate("Data"));
				res.setScheda(rs.getBlob("Scheda"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	public boolean SalvaScheda_allenamento(Scheda_allenamento sa) {
		String query = "INSERT INTO Username VALUES (?, ?, ?, ?)";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, sa.getUsername());
			ps.setString(2, sa.getTipologia());
			ps.setDate(3, sa.getData());
			ps.setBlob(4, sa.getScheda());
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
	public boolean EliminaScheda_allenamento(Scheda_allenamento sa) {
		String query = "DELETE * FROM Scheda_allenamento WHERE Username = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, sa.getUsername());
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
	public boolean AggiornaScheda_allenamento(Scheda_allenamento sa) {
		String query = "UPDATE Scheda_allenamento SET Password = ?, data = ? WHERE Username = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, sa.getTipologia());
			ps.setDate(2, sa.getData());
			ps.setString(3, sa.getUsername());
			ps.setBlob(4, sa.getScheda());
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

	public Vector<Scheda_allenamento> getAll(){
		String query = "SELECT * FROM Scheda_allenamento";
		Vector<Scheda_allenamento> list = new Vector<Scheda_allenamento>();
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(recordToScheda_allenamento(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return list;
	}

	public boolean ScaricaScheda() {
		String query = "SELECT Scheda FROM Scheda_allenamento WHERE Username = ? ";
		boolean esito= false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
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


	protected Scheda_allenamento recordToScheda_allenamento(ResultSet rs) throws SQLException {
		Scheda_allenamento res=new Scheda_allenamento();
		res.setUsername(rs.getString("Username"));
		res.setTipologia(rs.getString("Tipologia"));
		res.setData(rs.getDate("Data"));
		res.setScheda(rs.getBlob("Scheda"));
		return res;

	}
}
