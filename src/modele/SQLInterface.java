package modele;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * SqlInterface est l'interface pour la base de donnees
 * Elle permet d'utiliser differents types de bdd sans devoir tout recoder :
 * Il faut juste recreer une implementation de cette interface
 * @author Xavier Fraboulet
 */

public interface SQLInterface {
	
	/**
	 * Cette methode permet de se connecter a la bdd
	 * @param name of the database
	 */
	public Connection connect() throws SQLException;
	
	/**
	 * Cette metjode permet de faire une requete a la base de donnees
	 * @param query
	 * @return List<Map>
	 */
	public List<Map<String, Object>> query(String query) throws SQLException;
	
	/**
	 * Met a jour une base de donnees
	 * @param query
	 */
	public void update(String query) throws SQLException;
	
	/**
	 * @param table
	 * @return la liste des attributs (nom et type) d'une table
	 */
	public Map<String, Integer> getAttributs (String table);
}
