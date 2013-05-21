package controleur.basique;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import vue.fenetres.FenetreSupprimer;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class FenetreSupprimerAction extends AbstractAction {
	private ListeObjet listeObjet;
	
	/** L'action FenetreSupprimer permet l'appel de la fenetre Supprimer
	 * 
	 * @param listeObjet la liste des objet
	 * @see FenetreSupprimer
     * @see AbstractAction
	 */
	public FenetreSupprimerAction (ListeObjet listeObjet) {
		super(Langue.getTraduction("delete"));
    	this.listeObjet = listeObjet;
    }

	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see FenetreSupprimer
     * @see AbstractAction
	 */
    public void actionPerformed(ActionEvent e) {
    	new FenetreSupprimer(listeObjet);
    }
}
