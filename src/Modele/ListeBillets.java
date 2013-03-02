package Modele;

import java.util.ArrayList;
import java.util.List;


public class ListeBillets {
	private Billeterie billeterie;	
	private List<Billet> listeBillets = new ArrayList<Billet>();
	
	
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
	 * Cette methode commence par executer une requete sur la bdd. Un ResultSet est obtenu.
	 * Ce Result Set est transforme en une List de Billets.
	 * Le ResultSet est cloture a la fin de l operation.
	 */
	public void metEnMemoire() {
		//TODO
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
	
	
	/*
	 * Ajoute un billet dans la liste
	 * @param billet le billet à ajouter
	 * @return vrai si l'ajout est effectue, faux sinon
	 */
	public boolean ajoutBillet(Billet billet) {
		//TODO
		
		// tester la presence du billet dans la List
		
		// atribuer un id a ce billet (mettre un membre static dans la classe Billet)
		
		// enregistre le billet dans la bdd
		billet.enregistre();
		return true;
	}
	
}
