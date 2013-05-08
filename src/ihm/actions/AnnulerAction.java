package ihm.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ihm.fenetres.Fenetre;

@SuppressWarnings("serial")
public class AnnulerAction extends AbstractAction {
	
	private Fenetre fenetre;
	
	/** Permet d'annuler une action en cours en fermant la fenetre en parametre
	 * 
	 * @param fenetre la fenetre a fermer
	 * @see Fenetre
	 */
    public AnnulerAction(Fenetre fenetre) {
        super("Annuler");
        this.fenetre = fenetre;
    }
    
    /** Methode requise par l'implementation de l'interface AbstractAction
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		fenetre.dispose();
	}
}
