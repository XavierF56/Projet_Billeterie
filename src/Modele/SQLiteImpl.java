package Modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public SQLiteImpl(String name) throws ClassNotFoundException{
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
	public ResultSet query(String query) throws SQLException {
		// Check if this a SELECT query, if not, throw an exception
		String pattern = "^SELECT.*";
		if(query.matches(pattern)){
			
			Connection conn = connect();
			ResultSet res; /*Must be close by rs.close() after utilization*/
			try {
				// create statement
				Statement stmt = conn.createStatement();
				try {
					//execute query
					stmt.setQueryTimeout(iTimeout);
					res = stmt.executeQuery(query);
				} finally {
				    try { stmt.close(); } catch (Exception ignore) {}
				}
			} finally {
			    try { conn.close(); } catch (Exception ignore) {}
			}
			return res;
		}
		
		else{
			throw new SQLException("The query is not a SELECT query : " + query);
		}
	}

	/**
	 * Update a database
	 * @param query
	 */
	public void update(String query) throws SQLException {
		// Check if this an UPDATE query, if not, throw an exception
				String pattern = "^UPDATE.*";
				if(query.matches(pattern)){
					
					Connection conn = connect();
					try {
						// create statement
						Statement stmt = conn.createStatement();
						try {
							//execute query
							stmt.setQueryTimeout(iTimeout);
							stmt.executeQuery(query);
						} finally {
						    try { stmt.close(); } catch (Exception ignore) {}
						}
					} finally {
					    try { conn.close(); } catch (Exception ignore) {}
					}
				}
				
				else{
					throw new SQLException("The query is not a UPDATE query : " + query);
				}
	}

	/**
	 * Create a new table
	 * @param query
	 */
	public void create(String query) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
		
	}
	
	public static List<Map<String,Object>> transforme (ResultSet rs){
		//TODO
		return null;
	}
	
}
