package it.unirc.twd.beans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import it.unirc.twd.utils.DBManager;

public class PagamentoDAO {
	private static Connection conn = null;

	public Pagamento getPagamento(Pagamento p) {
		String query = "Select * FROM Pagamento where username = ? and data = ?";
		Pagamento res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Pagamento();
				res.setUsername(rs.getString("username"));
				res.setData(rs.getDate("data"));
				res.setMetodo(rs.getString("metodo"));
				res.setImporto(rs.getInt("importo"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}
	public boolean RegistraPagamento(Pagamento p) {
		String query = "INSERT INTO pagamento VALUES (?, ?, ?, ?)";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDate(1, p.getData());
			ps.setString(2, p.getMetodo());
			ps.setInt(3, p.getImporto());
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
	public boolean EliminaPagamento(Pagamento p) {
		String query = "DELETE * FROM Pagamento WHERE Username = ?, data=?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, p.getUsername());
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
	public boolean AggiornaPagamento(Pagamento p) {
		String query = "UPDATE Pagamento SET data = ?, metodo = ?, importo = ? WHERE Username = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDate(1, p.getData());
			ps.setString(2, p.getMetodo());
			ps.setInt(3, p.getImporto());
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
	protected Pagamento recordToPagamento(ResultSet rs) throws SQLException {
		Pagamento res=new Pagamento();
		res.setUsername(rs.getString("Username"));
		res.setMetodo(rs.getString("metodo"));
		res.setData(rs.getDate("Data"));
		res.setImporto(rs.getInt("importo"));
		return res;

	}

	public Vector<Pagamento> getAll(){
		String query = "SELECT * FROM Pagamento";
		Vector<Pagamento> list = new Vector<Pagamento>();
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(recordToPagamento(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return list;
	}

}
