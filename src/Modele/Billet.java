package Modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*************************CLASS USELESS !!!!!!!!!!!!!!!!!!!!!!!!!***************************/
public class Billet {
	/********** Attributs ************/
	private int id;
	private Map<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	private Billeterie bill;

	// id utilise par le prochain billet cree
	private static int prochainId; 
	
	
	/********** Methodes ************/
	/**
	 * A partir de la Map, ce constructeur renseigne le champ id(contenu dans la map) et map
	 * @param map2
	 */
	public Billet (Map<String, Object> map2, Billeterie bill){
		this.map = map2;
		this.bill = bill;
	}
	
	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete update
	 */
	public void enregistre() {
		try {
			bill.getBdd().enregistreBDD("billets", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete insert
	 */
	public void ajoutBDD(){
		try {
			bill.getBdd().ajoutBDD("billets", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Attribue un id au billet
	 */
	public void setId() {
		if (map.containsKey("id")) {
			map.put("id", prochainId);
			prochainId++;
		}
	}
	
	/**
	 * Ajoute un billet dans la liste
	 * @param billet le billet à ajouter
	 * @return vrai si l'ajout est effectue, faux sinon
	 */
	public void ajoutBillet() {
		// atribue un id a ce billet
		this.setId();
		
		// enregistre le billet dans la bdd
		this.ajoutBDD();
		
		// ajout du billet a ListeBillets
		bill.getListeBillets().ajoutBillet(this);
	}

	
	/********** Methodes de base ************/
	public static int getProchainId() {return prochainId;}
	public static void setProchainId(int prochainId) {Billet.prochainId = prochainId;}
	public int getId() {return (Integer) map.get("id");}
	public boolean equal(Billet bill) {return this.getId() == bill.getId();}
	public String toString () {return "\n Billet : " + map;}
}
