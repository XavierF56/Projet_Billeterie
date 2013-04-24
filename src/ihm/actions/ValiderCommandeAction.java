package ihm.actions;

import ihm.fenetres.Fenetre;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Commande;

@SuppressWarnings("serial")
public class ValiderCommandeAction extends AbstractAction {
	private Fenetre fenetre;
	private Commande commande;
	
	public ValiderCommandeAction(Fenetre fenetre, Commande commande) {
	    super("Valider");
	    this.fenetre = fenetre;
	    this.commande = commande;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			commande.valider();
	    	fenetre.setVisible(false);
		} catch (Exception e1) {
			String message = "\"Erreur lors de la modification\"\n"
			            + "Tous les champs n'ont pas ete renseignes\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
		}
	}
}