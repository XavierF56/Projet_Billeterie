package modele;

import general.Constantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
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
		this.sTempDb = name;
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
	public List<Map<String, Object>> query(String query) {
		List<Map<String, Object>> resul = new ArrayList<Map<String, Object>>();
		try {
			// Creation statement
			Connection conn = connect();
			ResultSet res = null; 
			Statement stmt = conn.createStatement();
				
			// Execute query
			stmt.setQueryTimeout(iTimeout);
			res = stmt.executeQuery(query);
			resul = this.transforme(res);
				
			// Fermeture des statements
			res.close(); 
			stmt.close();
			conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return resul;
	}

	
	/**
	 * Transforme un ResultSet en une List de Map.
	 * @param ResultSet
	 * @ return List
	 */
	private List<Map<String, Object>> transforme (ResultSet rs) {
		List<Map<String, Object>> resul = new ArrayList<Map<String, Object>>();
		ResultSetMetaData metadata;

		try {
			metadata = rs.getMetaData();
			int nombreColonnes = metadata.getColumnCount();
			while (rs.next()) {
				Map<String, Object> record = new HashMap<String, Object>();
				for (int i = 1; i <= nombreColonnes; i++){
					record.put(metadata.getColumnName(i), rs.getObject(i));
				}
				resul.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resul;
	}
	
	
	/**
	 * Update a database
	 * @param query
	 */
	public void update(String query){
		try {
			// Creation statement
			Connection conn = connect();
			Statement stmt = conn.createStatement();
				
			// Execute query
			stmt.setQueryTimeout(iTimeout);
			stmt.executeUpdate(query);
				
			// Fermeture des statements	
			stmt.close();
		   	conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param table
	 * @return la liste des attributs (nom et type) d'une table
	 */
	public Map<String, Integer> getAttributs (String table) {
		Map<String, Integer> resul = new HashMap<String, Integer>();
		try {
			// Creation statement
			Connection conn = connect();
			ResultSet res = null; 
			Statement stmt = conn.createStatement();
			
			// Execute query
			stmt.setQueryTimeout(iTimeout);
			res = stmt.executeQuery("Select * from " + table);
			ResultSetMetaData metadata = res.getMetaData();
			for(int i = 0; i < metadata.getColumnCount(); i++){
				String nomColonne = metadata.getColumnName(i+1);
			    if(!nomColonne.equals("id")) {
			    	resul.put(nomColonne, Constantes.stringToInt(metadata.getColumnTypeName(i+1)));
			    }
			}
			// Fermeture des statements
			res.close(); 
		    stmt.close();
		    conn.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return resul;
	}
}

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

