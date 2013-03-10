package Modele;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class Billet {
	
	/********** Attributs ************/
	private Map<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	private Billeterie bill;

	// id utilise par le prochain billet cree
	private static int prochainId; 
	
	
	/********** Constructeurs ************/
	
	/**
	 * Constructeur d'un billet deja present dans la bdd, 
	 * La map contient l'ensemble des attributs de l'objet ainsi que son id
	 * @param map
	 * @param bill
	 */
	public Billet(Map<String,Object> map, Billeterie bill) {
		this.map = map;
		this.bill = bill;
	}
	
	/**
	 * Constructeur d'un billet qui n'est pas present dans la bdd. Le billet a ete cree par l'utilisateur
	 * La map contient l'ensemble des attributs de l'objet mais pas son Id. Cet Id sera ajouté par le constructeur
	 * @param map
	 * @param bill
	 * @param useless ce param sert juste a diffrencier les deux constructeurs
	 */
	public Billet(Map<String,Object> map, Billeterie bill, int useless) {
		this.map = map;
		this.bill = bill;
		
		// Attribue un Id a ce nouveau billet
		if (!map.containsKey("id")) {
			map.put("id", prochainId);
			prochainId++;
		}
		
		// Enregistre le nouveau billet dans la bdd
		try {
			bill.getBdd().ajoutBDD("tickets", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Ajoute le billet a la listeBillets
		bill.getListeBillets().ajoutBillet(this.getId(), this);
	}
	
	
	
	/********** Methodes ************/
	
	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete update
	 *  @param map
	 */
	@SuppressWarnings("unused")
	private void modifie(Map<String,Object> nouvelleMap) {
		try {
			// Remplace l'ancienne map par la nouvelle en ajoutant l'id si celui-ci n'est pas present dans la nouvelle
			int ancId = this.getId();
			this.map = nouvelleMap;
			if (!map.containsKey("id")) {
				map.put("id", ancId);
			}
			
			// Sauvegarde les modifs dans la bdd
			bill.getBdd().enregistreBDD("tickets", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public int getNbPlace() {
		return (Integer) map.get("nb_total"); //NOM BDD
	}
	
	public int getPrixRed() {
		return (Integer) map.get("price_sub"); //NOM BDD
	}
	
	public int getPrixNor() {
		return (Integer) map.get("price"); //NOM BDD
	}
	
	public int getNbPlacePerso() {
		return (Integer) map.get("nb_per_person"); //NOM BDD
	}
	
	
	public static int getProchainId() {
		return prochainId;
	}
	public static void setProchainId(int prochainId) {
		Billet.prochainId = prochainId;
	}
	public int getId() {
		return (Integer) map.get("id");
	}
	public boolean equal(Billet bill) {
		return this.getId() == bill.getId();
	}
	public String toString () {
		return map +"\n";
	}
}
