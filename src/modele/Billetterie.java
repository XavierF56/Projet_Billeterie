package modele;

import vue.fenetres.FenetrePrincipale;
import general.Constantes;

/**
 * Cette class permet de faire le lien entre la base de donnees, les listeBillets et listePersonnes.
 * @author xavier
 */
public class Billetterie {
	private ListePersonnes listePersonnes = null;
	private ListeBillets listeBillets = null;
	private DataBase bdd;
	private FenetrePrincipale fenetre;
	private AchatsGeneral achatsGeneral = null;
		
	/********** Constructeur ************/
	public Billetterie (String nomBdd) {
		try{
			bdd = new DataBase(nomBdd);
		} catch (Exception e) {
			Constantes.afficherException(e);
		}
		achatsGeneral =  new AchatsGeneral(this);
		listeBillets = new ListeBillets(this);
		listePersonnes = new ListePersonnes(this);
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
