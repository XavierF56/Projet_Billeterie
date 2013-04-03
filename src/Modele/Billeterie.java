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
	}
	
	/********** Methodes ************/
	
	
	
	/********** Methodes de base ************/
	public ListePersonnes getListePersonnes() {
		return listePersonnes;
	}
	public void setListePersonnes(ListePersonnes listePersonnes) {
		this.listePersonnes = listePersonnes;
	}
	public ListeBillets getListeBillets() {
		return listeBillets;
	}
	public void setListeBillets(ListeBillets listeBillets) {
		this.listeBillets = listeBillets;
	}
	public SQLInterface getBdd() {
		return bdd;
	}
	public void setBdd(SQLInterface bdd) {
		this.bdd = bdd;
	}

	public static void main (String[] args){
		long start; 
		start = System.nanoTime();
		
		Billeterie bill = new Billeterie("database.sqlite");
		//System.out.println(bill.getListePersonnes() + "\n\n\n"); 
		//System.out.println(bill.getListeBillets() + "\n\n\n"); 
		Map<Integer, Billet> listeBill= bill.getListeBillets().recherche("cin");
		Map<Integer, Personne> listePerso= bill.getListePersonnes().recherche("Stark");
		
		Commande commande;
		try {
			commande = new Commande(bill.getListePersonnes().getPersonne(5));
			try {
				commande.ajoutCommande(bill.getListeBillets().getBillet(101), 10, true, true, true);
				System.out.println(commande);
				commande.ajoutCommande(bill.getListeBillets().getBillet(107), 10, true, true, true);
				System.out.println(commande);
				commande.ajoutCommande(bill.getListeBillets().getBillet(109), 10, true, true, true);
				System.out.println(commande);
				commande.ajoutCommande(bill.getListeBillets().getBillet(103), 10, true, true, true);
				System.out.println(commande);
			} catch (AchatException e) {
				e.printStackTrace();
				commande.valider();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		long duree = System.nanoTime() - start;
		System.out.println(duree);
	}
}
