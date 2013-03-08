package Modele;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personne {
	/********** Attributs ************/
	private Map<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	private Billeterie bill;
	
	private List<Map<String,Object>> achats; //INIT ?
	// Booleen permettant de savoir si il faut recuperrer/maj les achats depuis la bdd
	private boolean achatEnMem;

	// id utilise par le prochain billet cree
	private static int prochainId; 
	
	/********** Methodes ************/
	/**
	 * A partir de la Map, ce constructeur renseigne le champ id(contenu dans la map) et map
	 * @param map2
	 */
	public Personne (Map<String, Object> map, Billeterie bill){
		this.map = map;
		this.bill = bill;
		this.achatEnMem = false;
	}
	
	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete update
	 */
	private void enregistre() {
		try {
			bill.getBdd().enregistreBDD("people", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete insert
	 */
	private void ajoutBDD(){
		try {
			bill.getBdd().ajoutBDD("people", map); //NOM BDD
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
	 * Methode a utiliser apres la creation d une nouvelle personne
	 * Elle attribuera a cette personne un nouvel id unique
	 * Elle l ajoutera a la bdd et dans listPersonnes
	 */
	public void ajoutBillet() {
		this.setId();
		this.ajoutBDD();
		bill.getListePersonnes().ajoutPersonne(this.getId(), this);
	}
	
	/**
	 * Met en memoire les achats de la personne courante en memoire dans achats
	 */
	private void metEnMemAchats () {
		//purger la precedente liste
	}
	
	/**
	 * Realise un achat si cela est possible
	 * @param billet
	 * @param quantite
	 * @param paye
	 * @return vrai si l operation a reussie
	 */
	public boolean faireAchat(Billet billet, int quantite, boolean paye) {//autres para ?
		return true;
		//Doit balancer des exceptions => afficher des messages d erreurs
	}
	
	/**
	 * Verifie si cette personne peut profiter d un prix reduit
	 * @return
	 */
	public boolean prixReduit() {
		return true;
	}
	
	public int nbAchete(Billet billet) {
		return 0;
	}
	
	
	

	
	public static int getProchainId() {return prochainId;}
	public static void setProchainId(int prochainId) {Personne.prochainId = prochainId;}
	public int getId() {return (Integer) map.get("id");}
	public boolean equal(Personne pers) {return this.getId() == pers.getId();}
	public String toString () {return map +"\n";}
}