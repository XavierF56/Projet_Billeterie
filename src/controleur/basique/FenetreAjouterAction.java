package controleur.basique;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import vue.fenetres.FenetreAjouter;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class FenetreAjouterAction extends AbstractAction {
	
	private ListeObjet listeObjet;
	private String titre;
	private boolean sub;
	
	/** L'action FenetreAjouter permet l'appel de la fenetre Ajouter
	 * 
	 * @param listeObjet la liste des objet
	 * @param titre le titre de la fenetre qui sera appelee
	 * @see FenetreAjouter
     * @see AbstractAction
	 */
	public FenetreAjouterAction(ListeObjet listeObjet, String titre, boolean sub) {
        super(Langue.getTraduction("add"));
    	this.listeObjet = listeObjet;
    	this.titre = titre;
    	this.sub = sub;
    }

    /** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see FenetreAjouter
     * @see AbstractAction
	 */
    public void actionPerformed(ActionEvent e) {
    	new FenetreAjouter(listeObjet, titre, sub);
    }
}