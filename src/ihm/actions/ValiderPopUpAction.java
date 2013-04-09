package ihm.actions;

import ihm.fenetres.Fenetre;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class ValiderPopUpAction extends AbstractAction {
	
	private Fenetre fenetre;
	
    public ValiderPopUpAction(Fenetre fenetre) {
    	super("Valider");
    	this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Validation");
        fenetre.dispose();
    }
}