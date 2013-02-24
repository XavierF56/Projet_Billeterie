package Modele;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * SqlInterface is the interface for the DataBase
 *
 * @author Xavier Fraboulet
 * @version 1.0
 */

public interface SQLInterface {
	
	/**
	 * Connect to a database file or server. BTW, this method may need more param
	 * @param name of the database
	 */
	public Connection connect() throws SQLException;
	
	/**
	 * Create and send a query to the database
	 * @param query
	 * @return ResultSet with the information
	 */
	public ResultSet query(String query) throws SQLException;
	
	/**
	 * Update a database
	 * @param query
	 */
	public void update(String query) throws SQLException;
	
	/**
	 * Create a new table. Useless function. May not be implemented
	 * @param query
	 */
	public void create(String query) throws UnsupportedOperationException ;	
}
