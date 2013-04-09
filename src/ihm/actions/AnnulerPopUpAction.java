package ihm.actions;

import ihm.fenetres.Fenetre;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class AnnulerPopUpAction extends AbstractAction {
	private Fenetre fenetre;
    public AnnulerPopUpAction(Fenetre fenetre) {
        super("Annuler");
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e) {
        fenetre.dispose();
    }
}
