package Modele;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

//useless import for now
//import java.sql.ResultSetMetaData;
//import java.sql.DatabaseMetaData;
//A supprimer !!!

public class SQLiteConnect {
	public static void main (String[] args) throws Exception
	{
		// register the driver 
		String sDriverName = "org.sqlite.JDBC";
		Class.forName(sDriverName);
		 
		// now we set up a set of fairly basic string variables to use in the body of the code proper
		String sTempDb = "database.sqlite";
		String sJdbc = "jdbc:sqlite";
		String sDbUrl = sJdbc + ":" + sTempDb;
		
		// which will produce a legitimate Url for SqlLite JDBC :
		// jdbc:sqlite:database.db
		int iTimeout = 30;
		String sMakeSelect = "SELECT * from people";
		 
		// create a database connection
		Connection conn = DriverManager.getConnection(sDbUrl);
		
		try {
			// create statement
			Statement stmt = conn.createStatement();
			
			try {
				//execute querry
				stmt.setQueryTimeout(iTimeout);
				ResultSet rs = stmt.executeQuery(sMakeSelect);
				
				try {
					//print res
					while(rs.next())
					{
					String sResult = rs.getString("name");
					String sResult2 = rs.getString("first_name");
					System.out.println(sResult2 +" "+ sResult);
					}
				} finally {
				    try { rs.close(); } catch (Exception ignore) {}
				}
			} finally {
			    try { stmt.close(); } catch (Exception ignore) {}
			}
		} finally {
		    try { conn.close(); } catch (Exception ignore) {}
		}
	}
		 
}

