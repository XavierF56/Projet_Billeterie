package ihm.actions.fenetre;

import general.Langue;
import ihm.fenetres.FenetreSupprimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
		super(Langue.supprimer);
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
