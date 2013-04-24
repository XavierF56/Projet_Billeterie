package ihm.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AjouterAuPanierAction extends AbstractAction {
	
	public AjouterAuPanierAction() {
	    super("Ajouter au panier");
	}
	
	public void actionPerformed(ActionEvent e) {
		try {

		} catch (Exception e1) {
			String message = "\"Erreur lors de l'ajout au panier\"\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
		}
	}
}
