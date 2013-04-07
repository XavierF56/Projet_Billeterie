package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * This is the main class where you can launch the application
 * 
 */

public class Billeterie {
	private ListePersonnes listePersonnes;
	private ListeBillets listeBillets;
	private SQLInterface bdd;
	private Map<String, Integer> colonnesPersonnes;
	private Map<String, Integer> colonnesBillets;
		
	/* TODO ajouter une map<String, type> pour avoir les attributs de chaque objet (sans les id)
	 * La methode doit pouvoir marcher meme si la bdd est vide
	 * Elle enverra des exception si certains para necessaire ne sont pas presents (para de base)
	 */
	
	
	/********** Constructeur ************/
	public Billeterie (String nomBdd) {
		try{
			bdd = new SQLiteImpl(nomBdd);
		} catch (Exception e) {
			//TODO
		}
		listePersonnes = new ListePersonnes(this);
		listeBillets = new ListeBillets(this);
		colonnesPersonnes = ((SQLiteImpl) bdd).getColonnes("Personne");
		colonnesBillets = ((SQLiteImpl) bdd).getColonnes("Billet");
	}
	
	/********** Methodes ************/
	
	
	
	/********** Methodes de base ************/
	public ListePersonnes getListePersonnes() {
		return listePersonnes;
	}
	public ListeBillets getListeBillets() {
		return listeBillets;
	}
	public SQLInterface getBdd() {
		return bdd;
	}
	public Map<String, Integer> getColonnesBillets() {
		return colonnesBillets;
	}
	public Map<String, Integer> getColonnesPersonnes() {
		return colonnesPersonnes;
	}

	public static void main (String[] args){
		long start; 
		start = System.nanoTime();
		
		Billeterie bill = new Billeterie("database.sqlite");
			
		long duree = System.nanoTime() - start;
		System.out.println(duree);
		System.out.println(bill.getColonnesBillets());
		System.out.println(bill.getColonnesPersonnes());

	}
}
