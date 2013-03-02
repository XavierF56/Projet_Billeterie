package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListeBillets {
	/********** Attributs ************/
	private Billeterie billeterie;	
	private Map<Integer, Billet> listeBillets = new HashMap<Integer, Billet>();
	
	
	/********** Methodes ************/
	/* 
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListeBillets(Billeterie billeterie) {
		this.billeterie = billeterie;
		this.metEnMemoire();
	}
	
	/*
	 * Met en memoire l'ensemble des billets.
	 */
	public void metEnMemoire() {
		try {
			// Execute une requete sur la bdd pour obtenir un ResultSet
			ResultSet set = billeterie.getBdd().query("select * from billets");
			
			// Ce Result Set est transforme en une Map associant id a billet. ID etant le premier parametre du ResultSet
			//TODO
			
			// Cloture le ResultSet
			set.close();
		} catch (SQLException e){
			//TODO
			e.printStackTrace();
		}
	}
	
	/*
	 * Renvoie l'ensemble des billets lies a la recherche
	 * Q: recherche sur la bdd ou ici ? => a test
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public HashMap<Integer, Billet> recherche(String chaine) {
		//TODO
		/*
		 * diviser la chaine grace aux espaces
		 * tester chaque sous chaine avec les caracteristiques interessantes du billet et ajouter à la nouvelle List
		 */
		return null;
	}
	
	
	/*
	 * Ajoute un billet dans la liste
	 * @param billet le billet à ajouter
	 * @return vrai si l'ajout est effectue, faux sinon
	 */
	public void ajoutBillet(Billet billet) {
		// atribuer un id a ce billet
		billet.setId(Billet.getProchainId());
		Billet.setProchainId(Billet.getProchainId() + 1);
		billet.setBill(billeterie);
		
		// enregistre le billet dans la bdd
		billet.ajoutBDD();
		
		// ajout du billet a ListeBillets
		listeBillets.put(billet.getId(), billet);
	}
	
	/*
	 * Retourne le billet correspondant a l id 
	 * @param id du billet
	 * @return le billet
	 */
	public Billet chercheBillet(int id) {
		//TODO
		return null;
	}
	
	public String toString () {
		//TODO
		return null;
	}
	
	/********** Methodes de base ************/

	
}
