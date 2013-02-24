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
	public ListePersonnes (Billeterie billeterie){
		//TODO
	}
	
	
	/*
	 * Renvoie l'ensemble des billets lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public List<Personne> recherche(String chaine){
		//TODO
		return null;
	}
	
	
	/*
	 * Ajoute un billet dans la liste
	 * @param billet le billet à ajouter
	 */
	public void ajoutPersonne(Personne personne){
		//TODO
	}
}
