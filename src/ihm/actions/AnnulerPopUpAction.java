package ihm.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class AnnulerPopUpAction extends AbstractAction {
	private JDialog fenetre;
    public AnnulerPopUpAction(JDialog fenetre) {
        super("Annuler");
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e) {
        fenetre.dispose();
    }
}
