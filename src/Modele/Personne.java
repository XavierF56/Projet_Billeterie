package Modele;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personne {
	/********** Attributs ************/
	private Map<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	private Billeterie bill;
	private ListeAchats achats;
	
	// Booleen permettant de savoir si les acahts sont en memoire
	private boolean achatEnMem;

	// id utilise par la prochaine personne creee
	private static int prochainId; 
	
	/********** Constructeurs ************/
	
	/**
	 * Constructeur d'une personne deja presente dans la bdd, 
	 * La map contient l'ensemble des attributs de l'objet ainsi que son id
	 * @param map
	 * @param bill
	 */
	public Personne (Map<String, Object> map, Billeterie bill){
		this.map = map;
		this.bill = bill;
		this.achatEnMem = false;
		this.achats = new ListeAchats(this);
	}
	
	/**
	 * Constructeur d'une personne qui n'est pas present dans la bdd. La personne a ete creee par l'utilisateur
	 * La map contient l'ensemble des attributs de l'objet mais pas son Id. Cet Id sera ajouté par le constructeur
	 * @param map
	 * @param bill
	 * @param useless ce param sert juste a diffrencier les deux constructeurs
	 */
	public Personne (Map<String,Object> map, Billeterie bill, int useless){
		this.map = map;
		this.bill = bill;
		this.achatEnMem = false;
		this.achats = new ListeAchats(this);
		
		// Attribue un Id a cette nouvelle personne
		if (!map.containsKey("id")) {
			map.put("id", prochainId);
			prochainId++;
		}
		
		// Enregistre la nouvelle personne dans la bdd
		try {
			bill.getBdd().ajoutBDD("people", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Ajoute le billet a la listePersonne
		bill.getListePersonnes().ajoutPersonne(this.getId(), this);
	}
	
	/**
	 *  Cette methode modifie un billet et l'enregistre dans la bdd
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
			bill.getBdd().enregistreBDD("people", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Retourne le nombre de billet deja achete pour un Billet
	 */
	public int nbBilletsAchete(Billet billet) {
		//TODO
		return 0;
	}
	
	/**
	 * Retourne ce qui reste a payer (lorsqu'un billet n'est pas directement paye)
	 * @return le prix
	 */
	public float restantAPayer() {
		//TODO
		return 0;
	}
	
	/**
	 * Verifie si cette personne peut profiter d un prix reduit
	 * @return
	 */
	public boolean prixReduit(Billet bill, int qt) {
		return true;
	}

	
	
	

	public Billeterie getBilleterie() {return this.bill;}
	public static int getProchainId() {return prochainId;}
	public static void setProchainId(int prochainId) {Personne.prochainId = prochainId;}
	public int getId() {return (Integer) map.get("id");}
	public boolean equal(Personne pers) {return this.getId() == pers.getId();}
	public String toString () {return map +"\n";}

	public ListeAchats getAchats() {
		return this.achats;
	}
}