package modele;

import general.Constantes;
import ihm.fenetres.FenetrePrincipale;


public class Billeterie {
	private ListePersonnes listePersonnes = null;
	private ListeBillets listeBillets = null;
	private DataBase bdd;
	private FenetrePrincipale fenetre;
		
	/********** Constructeur ************/
	public Billeterie (String nomBdd) {
		try{
			bdd = new DataBase(nomBdd);
		} catch (Exception e) {
			Constantes.afficherException(e);
		}
		listePersonnes = new ListePersonnes(this);
		listePersonnes.metEnMemoire();// necessaire sinon nul pointer exception a cause de attributsAchats
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
}
