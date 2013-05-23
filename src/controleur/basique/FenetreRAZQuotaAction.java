package controleur.basique;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.ListeObjet;
import vue.fenetres.FenetreRAZQuota;
import vue.fenetres.FenetreSupprimer;

@SuppressWarnings("serial")
public class FenetreRAZQuotaAction extends AbstractAction {
	private ListeObjet listeObjet;
	
	/** L'action FenetreSupprimer permet l'appel de la fenetre Supprimer
	 * 
	 * @param listeObjet la liste des objet
	 * @see FenetreSupprimer
     * @see AbstractAction
	 */
	public FenetreRAZQuotaAction (ListeObjet listeObjet) {
		super(Langue.getTraduction("reset_Quota"));
    	this.listeObjet = listeObjet;
    }

	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see FenetreSupprimer
     * @see AbstractAction
	 */
    public void actionPerformed(ActionEvent e) {
    	new FenetreRAZQuota(listeObjet);
    }
}
