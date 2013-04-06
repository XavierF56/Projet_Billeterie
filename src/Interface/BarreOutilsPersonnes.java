package Interface;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class BarreOutilsPersonnes extends BarreOutils {
	FenetrePrincipale fenetre;
	/**
	 * Premiere version de la barre d'outils d'onglet Personnes
	 */
	private static final long serialVersionUID = 1L;

	public BarreOutilsPersonnes(FenetrePrincipale fenetre) {
		super();
		this.fenetre = fenetre;
		this.add(txtRechercher);
		this.add(btnRechercher);
		this.add(new JButton(new AjouterAction()));
		this.add(btnModifier);
		this.add(btnSupprimer);
	}
	class AjouterAction extends AbstractAction {
        private AjouterAction() {
            super("Ajouter");
        }
 
        public void actionPerformed(ActionEvent e) {
            fenetre.getModelePersonnes().ajouter();
        }
    }
}
