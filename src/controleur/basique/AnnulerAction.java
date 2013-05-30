package controleur.basique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import vue.fenetres.Fenetre;

@SuppressWarnings("serial")
public class AnnulerAction extends AbstractAction {
	
	private Fenetre fenetre;
	
	/** Permet d'annuler une action en cours en fermant la fenêtre en parametre
	 * 
	 * @param fenetre la fenêtre à fermer
	 * @param titre le titre de l'action
	 * @see AbstractAction
	 * @see Fenetre
	 */
    public AnnulerAction(Fenetre fenetre, String titre) {
        super(titre);
        this.fenetre = fenetre;
    }
    
    /** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
     * @see Fenetre
	 */
	public void actionPerformed(ActionEvent e) {
		fenetre.dispose();
	}
}
