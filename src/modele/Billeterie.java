package modele;

import ihm.fenetres.FenetrePrincipale;

/*
 * This is the main class where you can launch the application
 * 
 */

public class Billeterie {
	private ListePersonnes listePersonnes;
	private ListeBillets listeBillets;
	private DataBase bdd;
	private FenetrePrincipale fenetre;
	
	/********** Constructeur ************/
	public Billeterie (String nomBdd) {
		try{
			bdd = new DataBase(nomBdd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listePersonnes = new ListePersonnes(this);
		listeBillets = new ListeBillets(this);
	}
	
	/********** Methodes ************/
	
	
	
	/********** Getters ************/
	public ListePersonnes getListePersonnes() {
		return listePersonnes;
	}
	public ListeBillets getListeBillets() {
		return listeBillets;
	}
	public DataBase getBdd() {
		return bdd;
	}
	public FenetrePrincipale getFenetre() {
		return fenetre;
	}
	public void setFenetre(FenetrePrincipale fenetre) {
		this.fenetre = fenetre;
	}

	public static void maintt (String[] args){
		/*long start; 
		start = System.nanoTime();
		
		Billeterie bill = new Billeterie("database.sqlite");
			
		long duree = System.nanoTime() - start;
		System.out.println(duree);*/
	}
}
