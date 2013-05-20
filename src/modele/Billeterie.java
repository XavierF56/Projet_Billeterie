package modele;

import general.Constantes;
import ihm.fenetres.FenetrePrincipale;


public class Billeterie {
	private ListePersonnes listePersonnes = null;
	private ListeBillets listeBillets = null;
	private DataBase bdd;
	private FenetrePrincipale fenetre;
	private AchatsGeneral achatsGeneral;
		
	/********** Constructeur ************/
	public Billeterie (String nomBdd) {
		try{
			bdd = new DataBase(nomBdd);
		} catch (Exception e) {
			Constantes.afficherException(e);
		}
		achatsGeneral =  new AchatsGeneral(this);
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
	public AchatsGeneral getAchatsGeneral() {
		return achatsGeneral;
	}
}
