package Modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Personne {
	public Map<String,Object> map = new HashMap<String,Object>();
	private Billeterie bill;
	private ListeAchats achats;
	
	// Booleen permettant de savoir si les acahts sont en memoire
	private boolean achatEnMem;

	// id utilise par la prochaine personne creee
	private static int prochainId; 
	
	// TODO fonction supprimer
	
	
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
			bill.getBdd().ajoutBDD("personne", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Ajoute le billet a la listePersonne
		bill.getListePersonnes().ajoutPersonne(this.getId(), this);
	}
	
	
	/********** Methodes ************/
	/**
	 *  Cette methode modifie un billet et l'enregistre dans la bdd
	 *  @param map
	 */
	public void modifie(Map<String,Object> nouvelleMap) {
		try {
			// Remplace l'ancienne map par la nouvelle en ajoutant l'id si celui-ci n'est pas present dans la nouvelle
			int ancId = this.getId();
			this.map = nouvelleMap;
			if (!map.containsKey("id")) {
				map.put("id", ancId);
			}
			
			// Sauvegarde les modifs dans la bdd
			bill.getBdd().enregistreBDD("personne", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void supprimer() {
		bill.getListePersonnes().supprimer(this);
	}
	
	/**
	 * Retourne le nombre de billet deja achete pour un Billet
	 * @param billet
	 * @return le nb de billets achetes
	 */
	public int nbBilletsAchete(Billet billet) {
		//Met en memoire la liste des achats
		if (!achatEnMem) {
			achats.metEnMemoire();
		}
		List<Achat> liste = this.achats.getListeAchats();
		int id = billet.getId();
		int resul = 0;
		
		for (int i = 0; i < liste.size(); i++) {
			if (id == liste.get(i).getBillet().getId()) {
				resul += liste.get(i).getQt();
			}
		}
		return resul;
	}
	
	/**
	 * Retourne ce qui reste a payer (lorsqu'un billet n'est pas directement paye)
	 * @return le prix
	 */
	public float restantAPayer() {
		//Met en memoire la liste des achats
		if (!achatEnMem) {
			achats.metEnMemoire();
		}
		List<Achat> liste = this.achats.getListeAchats();
		float resul = 0;
		
		for (int i = 0; i < liste.size(); i++) {
			if (! liste.get(i).getPaye()) {
				resul += liste.get(i).getPrixTotal();
			}
		}
		return resul;
	}

		
	/********** Getters & Setters************/
	public static void setProchainId(int prochainId) {
		Personne.prochainId = prochainId;
	}
	public Billeterie getBilleterie() {
		return this.bill;
	}
	public static int getProchainId() {
		return prochainId;
	}
	public int getId() {
		return (Integer) map.get("id");
	}
	public String getNom() {
		return (String) map.get("nom");
	}
	public String getPrenom() {
		return (String) map.get("prenom");
	}
	public ListeAchats getAchats() {
		return this.achats;
	}
	public boolean isAchatEnMem() {
		return achatEnMem;
	}
	public void setAchatEnMem(boolean achatEnMem) {
		this.achatEnMem = achatEnMem;
	}
	

	public List<String> getNomColonne() {
		List<String> res = new ArrayList<String>();
		Set set = map.keySet();
		java.util.Iterator it = set.iterator();
		while (it.hasNext()) {
			res.add((String) it.next());
		}
		return res;
	}
	
	public Map<String, Object> getHashMap() {
		return map;
	}

	
	/********** Methodes de base ************/
	public boolean equal(Personne pers) {
		return this.getId() == pers.getId();
	}
	public String toString () { //NOM BDD
		return map.get("prenom") + " " + map.get("nom");
	}
}