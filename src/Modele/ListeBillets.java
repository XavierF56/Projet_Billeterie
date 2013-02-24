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
	public ListeBillets(Billeterie billeterie){
		//TODO
	}
	
	
	/*
	 * Renvoie l'ensemble des billets lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public List<Billet> recherche(String chaine){
		//TODO
		return null;
	}
	
	
	/*
	 * Ajoute un billet dans la liste
	 * @param billet le billet à ajouter
	 */
	public void ajoutBillet(Billet billet){
		//TODO
	}
	
}
