package Modele;

import java.util.ArrayList;
import java.util.List;

public class ListePersonnes {
	private Billeterie billeterie;	
	private List<Personne> listePersonnes = new ArrayList<Personne>();
	
	
	/* 
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListePersonnes (Billeterie billeterie) {
		this.billeterie = billeterie;
		this.metEnMemoire();
	}
	
	/*
	 * Met en memoire l'ensemble des personnes.
	 * Cette methode commence par executer une requete sur la bdd. Un ResultSet est obtenu.
	 * Ce Result Set est transforme en une List de Personnes.
	 * Le ResultSet est cloture a la fin de l operation.
	 */
	public void metEnMemoire() {
		//TODO
	}
	
	
	/*
	 * Renvoie l'ensemble des personnes lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public List<Personne> recherche(String chaine){
		//TODO
		return null;
	}
	
	
	/*
	 * Ajoute une Personne dans la liste et enregistre dans la bdd
	 * @param billet le billet à ajouter
	 * @return vrai si l'ajout est effectue, faux sinon
	 */
	public boolean ajoutPersonne(Personne personne){
		//TODO
		return true;
	}
}
