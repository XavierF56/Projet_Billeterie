package ihm.actions;

import general.Langue;
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
	    super(Langue.cloturerCommande);
	    this.fenetre = fenetre;
	    this.commande = commande;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			commande.cloturer();
			fenetre.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), Langue.erreurAchat, Langue.erreur, JOptionPane.ERROR_MESSAGE);
			fenetre.dispose();
		}
	}
}