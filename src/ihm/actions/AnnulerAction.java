package ihm.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ihm.fenetres.Fenetre;

public class AnnulerAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private Fenetre fenetre;
	

    public AnnulerAction(Fenetre fenetre) {
        super("Annuler");
        this.fenetre = fenetre;
    }

	public void actionPerformed(ActionEvent e) {
		fenetre.dispose();
	}
}
