package modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ListeBillets {
	/********** Attributs ************/
	private Billeterie billeterie;	
	private List<Billet> listeBillets;
	private List<Billet> listeBilletsSauvegarde;
	
	/********** Constructeur ************/
	/**
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListeBillets(Billeterie billeterie) {
		this.billeterie = billeterie;
		listeBillets = new ArrayList<Billet>();
		this.metEnMemoire(); 
	}
	
	
	/********** Methodes ************/
	/**
	 * Met en memoire l'ensemble des billets.
	 */
	public void metEnMemoire() {
		try {
			List<Map<String, Object>> list = billeterie.getBdd().query("SELECT * from billet"); //NOM BDD
			for (int i = 0; i < list.size(); i++){
				listeBillets.add(new Billet(list.get(i), billeterie));
			}
			Billet.setProchainId((Integer)list.get(listeBillets.size() - 1).get("id")+1);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Renvoie l'ensemble des billets lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public List<Billet> recherche(String chaine) {
		//A develloper ! 
		reinitialise();
		List<Billet> resul= new ArrayList<Billet>();
		
		try {
			String query = "SELECT id FROM billet WHERE categorie LIKE '" + chaine +"%'"; //NOM BDD
			List<Map<String, Object>> list = billeterie.getBdd().query(query);
			for (int i = 0; i < list.size(); i++) {
				int valI = (Integer)list.get(i).get("id");
				if (listeBillets.containsKey(valI)) {
					resul.put(valI, listeBillets.get(valI));
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return resul;
	}
	
	/**
	 * Ajoute un billet dans la liste
	 * @param billet
	 */
	public void ajoutBillet(int id, Billet billet) {
		listeBillets.put(id, billet);
	}

	
	/********** Methodes de base ************/
	public Billet getBillet(int id) throws Exception {
		if (listeBillets.containsKey(id)){
			return listeBillets.get(id);
		} else {
			throw new Exception("Billet non existant");
		}
	}
	public String toString () {
		return listeBillets.toString();
	}
}
