package it.unirc.twd.beans;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


import it.unirc.twd.utils.DBManager;
import oracle.jdbc.internal.OracleTypes;

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
				res.setAnno(rs.getInt("anno"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}


	public Utente getUtenteByString(String u) {
		String query = "Select * FROM Utente where username = ?";
		Utente res = null;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, u);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res=new Utente();
				res.setUsername(rs.getString("username"));
				res.setPassword(rs.getString("password"));
				res.setAutorita(rs.getString("autorità"));
				res.setNome(rs.getString("nome"));
				res.setCognome(rs.getString("cognome"));
				res.setAnno(rs.getInt("anno"));
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		DBManager.closeConnection();
		return res;
	}


	public boolean SalvaUtente(Utente ut) {
		String query = "INSERT INTO Utente VALUES (?, ?, ?, ?, ?, ?)";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ut.getUsername());
			ps.setString(2, ut.getPassword());
			ps.setString(3, ut.getAutorita());
			ps.setString(4, ut.getNome());
			ps.setString(5,  ut.getCognome());
			ps.setInt(6, ut.getAnno());
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
	public boolean EliminaByString(String ut) {
		String query = "DELETE FROM Utente WHERE Username = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ut);
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
	public boolean AggiornaUtente(Utente ut) {
		String query = "UPDATE Utente SET Password = ?, autorità = ?, nome = ?, cognome = ?, anno = ?  WHERE Username = ?";
		boolean esito=false;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ut.getPassword());
			ps.setString(2, ut.getAutorita());
			ps.setString(5, ut.getUsername());
			ps.setString(3,  ut.getNome());
			ps.setString(4,  ut.getCognome());
			ps.setInt(6,  ut.getAnno());
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
	public boolean AggiornaPassword(Utente u) {
		String query = "UPDATE Utente SET Password = ? WHERE Username = ?";
		boolean esito = false;
		conn = DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getPassword());
			ps.setString(2, u.getUsername());
			int tmp = ps.executeUpdate();
			if(tmp==1) {
				esito = true;
			}
		}
		catch(Exception e) {
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
		res.setAnno(rs.getInt("anno"));
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

	public int ContaClienti() {
		String query = "SELECT COUNT(*) FROM utente WHERE AUTORITÀ='Cliente'";
		int numero = 0;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				numero=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		System.out.println(numero);
		return numero;
	}

	public int ContaAdmin() {
		String query = "SELECT COUNT(*) FROM utente WHERE AUTORITÀ='Admin'";
		int numero = 0;
		conn=DBManager.startConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				numero=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		System.out.println(numero);
		return numero;
	}
	public Vector<Utente> getAllClienti(){
		String query = "SELECT * FROM Utente WHERE AUTORITÀ = 'Cliente'";
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


	public boolean EsisteCliente(String ut) {
		String query = "Select * FROM Utente where username = ? and AUTORITÀ='Cliente'";
		boolean res = false;
		PreparedStatement ps;
		conn=DBManager.startConnection();
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, ut);
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
	public int AumentoIscrizioni(int anno) {
		String query = "{  ? = call AUMENTOISCRIZIONI(?) }";
		int risultato = 0;
		conn = DBManager.startConnection();
		try {
			CallableStatement cs = conn.prepareCall(query);
			cs.setInt(2,  anno);
			cs.registerOutParameter(1, OracleTypes.INTEGER);
			cs.execute();
			risultato = cs.getInt(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		DBManager.closeConnection();
		return risultato;
	}
}
