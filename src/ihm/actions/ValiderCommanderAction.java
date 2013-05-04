package ihm.actions;

import ihm.fenetres.Fenetre;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Commande;

@SuppressWarnings("serial")
public class ValiderCommanderAction extends AbstractAction {
	private Fenetre fenetre;
	private Commande commande;
	
	public ValiderCommanderAction(Fenetre fenetre, Commande commande) {
	    super("Valider");
	    this.fenetre = fenetre;
	    this.commande = commande;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			commande.valider();
			fenetre.dispose();
		} catch (Exception e1) {
			String message = "Une erreur s'est produite lors de votre achat\n La commande a été annulée\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
			fenetre.dispose();
		}
	}
}