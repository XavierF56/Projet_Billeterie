package ihm.actions;

import ihm.fenetres.Fenetre;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Commande;

@SuppressWarnings("serial")
public class CloturerCommanderAction extends AbstractAction {
	private Fenetre fenetre;
	private Commande commande;
	
	public CloturerCommanderAction(Fenetre fenetre, Commande commande) {
	    super("Cloturer la commande");
	    this.fenetre = fenetre;
	    this.commande = commande;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			commande.cloturer();
			fenetre.dispose();
		} catch (Exception e1) {
			String message = "Une erreur s'est produite lors de votre achat\nLa commande a été annulée";
			JOptionPane.showMessageDialog(new JFrame(), message, "Erreur", JOptionPane.ERROR_MESSAGE);
			fenetre.dispose();
		}
	}
}