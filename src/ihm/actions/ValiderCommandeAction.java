package ihm.actions;

import ihm.fenetres.Fenetre;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ValiderCommandeAction extends AbstractAction {
	Fenetre fenetre;
	public ValiderCommandeAction(Fenetre fenetre) {
	    super("Valider");
	    this.fenetre = fenetre;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
	    	fenetre.setVisible(false);
		} catch (Exception e1) {
			String message = "\"Erreur lors de la modification\"\n"
			            + "Tous les champs n'ont pas ete renseignes\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
		}
	}
}