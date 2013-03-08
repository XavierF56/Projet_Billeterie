package Modele;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/*************************CLASS USELESS !!!!!!!!!!!!!!!!!!!!!!!!!***************************/
public class Billet {
	/********** Attributs ************/
	private Map<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	private Billeterie bill;

	// id utilise par le prochain billet cree
	private static int prochainId; 
	
	
	/********** Methodes ************/
	/**
	 * A partir de la Map, ce constructeur renseigne le champ id(contenu dans la map) et map
	 * @param map2
	 */
	public Billet (Map<String, Object> map, Billeterie bill){
		this.map = map;
		this.bill = bill;
	}
	
	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete update
	 */
	private void enregistre() {
		try {
			bill.getBdd().enregistreBDD("tickets", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete insert
	 */
	private void ajoutBDD(){
		try {
			bill.getBdd().ajoutBDD("tickets", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Attribue un id au billet
	 */
	private void setId() {
		if (map.containsKey("id")) {
			map.put("id", prochainId);
			prochainId++;
		}
	}
	
	/**
	 * Methode a utiliser apres la creation d un nouveau billet
	 * Elle attribuera ce billet un nouvel id unique
	 * Elle l ajoutera a la bdd et dans listBillets
	 */
	public void ajoutBillet() {
		this.setId();
		this.ajoutBDD();
		bill.getListeBillets().ajoutBillet(this.getId(), this);
	}

	
	public static int getProchainId() {return prochainId;}
	public static void setProchainId(int prochainId) {Billet.prochainId = prochainId;}
	public int getId() {return (Integer) map.get("id");}
	public boolean equal(Billet bill) {return this.getId() == bill.getId();}
	public String toString () {return map +"\n";}
}
