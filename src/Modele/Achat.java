package Modele;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Achat {
	private Map<String,Object> map = new HashMap<String,Object>();
	private Personne personne;
	

	
	/********** Constructeurs ************/
	
	/**
	 * Constructeur d'un achat deja present dans la bdd, 
	 * La map contient l'ensemble des attributs de l'objet ainsi que les id Billet et Personne. 
	 * @param map
	 * @param personne
	 */
	public Achat(Map<String,Object> map, Personne perso) {
		this.map = map;
		this.personne = perso;
	}
	
	/**
	 * Lorsqu'une commande a ete validee, cette methode permet d'enregistrer chaque achat 
	 * dans la liste des achats d'une personne ainsi que dans la bdd.
	 */
	public void enregistre() {
		// Enregistre l'achat dans la bdd
		try {
			personne.getBilleterie().getBdd().ajoutBDD("purchase", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Ajoute l'achat à achats
		personne.getAchats().ajoutAchat(this);
	}
	
	/********** Methodes ************/
	/**
	 * Modifie l'attribut "paye" de l'achat 
	 * Cela signifie que les billets ont ete payes
	 */
	public void payer() {
		// TODO
	}
	
	/**
	 * Modifie l'attribut "donne" de l'achat 
	 * Cela signifie que les billets ont ete donnes a la personne
	 */
	public void donner() {
		// TODO
	}
	
	// GETTERS sur les attributs importants
	public boolean getPaye() {
		//TODO
		return true;
	}
	public boolean getDonne() {
		//TODO
		return true;
	}
	public boolean getPrixReduit() {
		//TODO
		return true;
	}
	public int getBillet() {
		//TODO
		return 0;
	}
	public int getQt() {
		//TODO
		return 0;
	}
	public int getPrixTotal() {
		//TODO
		return 0;
	}
}
