package ihm.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import modele.ListeObjet;

import ihm.fenetres.FenetreAjouter;

@SuppressWarnings("serial")
public class FenetreAjouterAction extends AbstractAction {
	
	private ListeObjet listeObjet;
	private String titre;
	
	/** Cette action permet l'appel de la fenetre Ajouter
	 * 
	 * @param listeObjet la liste des objet
	 * @param titre le titre de la fenetre qui sera appelee
	 * @see FenetreAjouter
     * @see AbstractAction
	 */
	public FenetreAjouterAction(ListeObjet listeObjet, String titre) {
        super("Ajouter");
    	this.listeObjet = listeObjet;
    	this.titre = titre;
    }

    /** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see FenetreAjouter
     * @see AbstractAction
	 */
    public void actionPerformed(ActionEvent e) {
    	new FenetreAjouter(listeObjet, titre);
    }
}