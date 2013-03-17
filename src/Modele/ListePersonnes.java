package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListePersonnes {
	/********** Attributs ************/
	private Billeterie billeterie;	
	private Map<Integer, Personne> listePersonnes = new HashMap<Integer, Personne>();
	
	
	/********** Methodes ************/
	/**
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListePersonnes(Billeterie billeterie) {
		this.billeterie = billeterie;
		this.metEnMemoire();
	}
	
	/**
	 * Met en memoire l'ensemble des billets.
	 */
	public void metEnMemoire() {
		try {
			List<Map<String, Object>> list = billeterie.getBdd().query("SELECT * from personne"); //NOM BDD
			for (int i = 0; i < list.size(); i++){
				listePersonnes.put((Integer)list.get(i).get("id"),new Personne(list.get(i), billeterie));
			}
			Billet.setProchainId((Integer)list.get(listePersonnes.size() - 1).get("id"));
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Renvoie l'ensemble des billets lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public Map<Integer, Personne> recherche(String chaine) {
		//A develloper ! 
		Map<Integer, Personne> resul= new HashMap<Integer, Personne>();
		
		try {
			String query = "SELECT id FROM personne WHERE name LIKE '" + chaine +"%'"; //NOM BDD
			List<Map<String, Object>> list = billeterie.getBdd().query(query);
			for (int i = 0; i < list.size(); i++) {
				int valI = (Integer)list.get(i).get("id");
				if (listePersonnes.containsKey(valI)) {
					resul.put(valI, listePersonnes.get(valI));
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return resul;
	}
	
	
	/**
	 * Ajoute une personne dans la liste
	 * @param billet
	 */
	public void ajoutPersonne(int id, Personne pers) {
		listePersonnes.put(id, pers);
	}
	
	/**
	 * 
	 * @param id
	 * @return null si pas de billet
	 */
	public Personne getPersonne(int id) {
		if (listePersonnes.containsKey(id)){
			return listePersonnes.get(id);
		} else {
			return null;
		}
	}
	
	public String toString () {
		return listePersonnes.toString();
	}
}
