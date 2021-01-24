package it.unirc.twd.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static Connection conn = null; 
	private static final String DbDriver = "oracle.jdbc.driver.OracleDriver";
	private static final String DbURL = "jdbc:oracle:thin:@localhost:1521:GlobalDB";
	private static final String username = "hr";   	
 	private static final String password = "hr";   
 	private DBManager(){} 
 	/** 
 	 * Metododo che restituisce true se la connessione è aperta. 
 	 */ 
 public static boolean isOpen() {
// 	 
// 	 	 	return false; 
// 	 	else 
// 	 	 	return true; 
	 	return (conn!=null); 
	} 	

	public static Connection startConnection(){ 
	 	if ( isOpen() ) 
	 	 	return conn; 
	 	try { 
	 	 	Class.forName(DbDriver);// Carica il Driver del DBMS 
	 	 	conn = DriverManager.getConnection(DbURL, username, password);// Apertura connessione 
	 	} 
	 	catch (Exception e) { 
	 	 	e.printStackTrace();  	 	 	return null; 
	 	} 
	 	return conn;  	} 
	 
	public static boolean closeConnection(){ 
	 	if ( !isOpen() ) 
	 	 	return true;  	 	try { 
	 	 	conn.close(); 
	 	 	conn = null; 
	 	}  
	 	catch (SQLException e){ 
	 	 	e.printStackTrace();  	 	 	return false; 
	 	} 
	 	return true; 
	} 
}