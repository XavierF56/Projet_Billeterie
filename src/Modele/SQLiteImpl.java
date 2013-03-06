package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLiteImpl implements SQLInterface{
	// register the driver 
	String sDriverName = "org.sqlite.JDBC";
	
	// now we set up a set of fairly basic string variables to use in the body of the code proper
	String sTempDb = "database.sqlite";
	String sJdbc = "jdbc:sqlite";
	String sDbUrl = sJdbc + ":" + sTempDb;
	
	int iTimeout = 30;	 

	public SQLiteImpl(String name) throws Exception{
		sTempDb = name;
		Class.forName(sDriverName);
	}
	
	/**
	 * Create a database connection. BTW, this method may need more param
	 * @param name of the database
	 * @return Connection
	 */
	public Connection connect() throws SQLException {
		return DriverManager.getConnection(sDbUrl);	
	}

	/**
	 * Create and send a query to the database
	 * @param query
	 * @return ResultSet with the information
	 */
	public List<List<Object>> query(String query) throws SQLException {
		// Check if this a SELECT query, if not, throw an exception
		String pattern = "^SELECT.*";
		List<List<Object>> resul = new ArrayList<List<Object>>();
		
		if(query.matches(pattern)){
			Connection conn = connect();
			ResultSet res = null; 
			try {
				// Cree statement
				Statement stmt = conn.createStatement();
				
				// Execute query
				stmt.setQueryTimeout(iTimeout);
				res = stmt.executeQuery(query);
				resul = this.transforme(res);
				
				// Fermeture des statements ...
				res.close(); 
			    stmt.close();
			    conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
			return resul;
		} else {
			throw new SQLException("The query is not a SELECT query : " + query);
		}
	}

	/**
	 * Update a database
	 * @param query
	 */
	public void update(String query) throws SQLException {
		// Check if this a SELECT query, if not, throw an exception
		String pattern = "^['UPDATE''INSERT INTO'].*";
		
		if(query.matches(pattern)){
			Connection conn = connect();
			ResultSet res = null; 
			try {
				// Cree statement
				Statement stmt = conn.createStatement();
				
				// Execute query
				stmt.setQueryTimeout(iTimeout);
				stmt.executeUpdate(query);
				
				// Fermeture des statements ...
			    stmt.close();
			    conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		} else {
			throw new SQLException("The query is not a SELECT query : " + query);
		}
	}

	/**
	 * Create a new table
	 * @param query
	 */
	public void create(String query) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}
	
	/**
	 * Transforme un ResultSet en une List de Map.
	 * @param ResultSet
	 * @ return List
	 */
	public List<List<Object>> transforme (ResultSet rs) {
		List<List<Object>> resul = new ArrayList<List<Object>>();
		ResultSetMetaData metadata;

		try {
			metadata = rs.getMetaData();
			int nombreColonnes = metadata.getColumnCount();
			while (rs.next()) {
				List<Object> record = new ArrayList<Object>();
				for (int i = 1; i <= nombreColonnes; i++){
					record.add(rs.getObject(i));
				}
				resul.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;
	}
	
	public void enregistreBDD (String table, int id, HashMap<String, Object> map) {
		//TODO
	}
	
	public void ajoutBDD (String table, int id, HashMap<String, Object> map) {
		//TODO
	}
	
	

	
	public static void main (String[] args) throws SQLException{
		Billeterie bill = new Billeterie("database.sqlite");
		
		/*List<List<Object>> list = bill.getBdd().query("SELECT * FROM people");
		System.out.println(list);*/

		bill.getBdd().update("UPDATE");
		
		
		//CREATION MULTIBLE D ENTREES POUR METHODE UPDATE
		/*for (int w = 21000; w < 32000; w++){
			String sql = "INSERT INTO people \nSELECT " + w + ", 'pierre', 'Durand'";

			for (int y = w + 1 ; y < w + 500; y++){
				sql = sql.concat(" \n UNION \n SELECT " + y + ", 'pierre', 'durand'");
			}
			w += 500;
			System.out.println(sql);
			stmt.executeUpdate(sql);
		}*/
		
		
		
	}
	
}
