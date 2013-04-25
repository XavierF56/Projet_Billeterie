package ihm.actions;

import ihm.fenetres.FenetreQuantite;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ValiderQuantiteAction extends AbstractAction {
		FenetreQuantite fenetre;
		
		public ValiderQuantiteAction(FenetreQuantite fenetreQuantite) {
		    super("Valider");
		    this.fenetre = fenetreQuantite;
		}
		
		public void actionPerformed(ActionEvent e) {
			try {
		    	fenetre.dispose();
			} catch (Exception e1) {
				String message = "\"Erreur du choix de la quantité\n"
				            + "Commande de ce billet annulée\n";
				JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
			}
		}
	}