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
	private List<Billet> listeBillets = new ArrayList<Billet>();
	
	
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
			List<Map<String, Object>> list = billeterie.getBdd().query("SELECT * from tickets");
			for (int i = 0; i < list.size(); i++){
				listeBillets.add(new Billet(list.get(i), billeterie));
			}
			Billet.setProchainId(listeBillets.get(listeBillets.size() - 1).getId());
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * Renvoie l'ensemble des billets lies a la recherche
	 * Q: recherche sur la bdd ou ici ? => a test
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public List<Billet> recherche(String chaine) {
		//TODO
		/*
		 * diviser la chaine grace aux espaces
		 * tester chaque sous chaine avec les caracteristiques interessantes du billet et ajouter à la nouvelle List
		 */
		return null;
	}
	
	
	/**
	 * Ajoute un billet dans la liste
	 * @param billet
	 */
	public void ajoutBillet(Billet billet) {
		listeBillets.add(billet);
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
		return listeBillets.toString();
	}
	
	/********** Methodes de base ************/

	
}
