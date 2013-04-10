package ihm.actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ihm.fenetres.Fenetre;
import ihm.fenetres.FenetreAvertissement;

@SuppressWarnings("serial")
public class SupprimerPersonneAction extends AbstractAction {
	Fenetre fenetre;

	public SupprimerPersonneAction(Fenetre fenetre) {
        super("Supprimer");
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e) {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreAvertissement frame = new FenetreAvertissement(
							"Confirmer la suppression", 
							"Voulez-vous vraiement supprimer "+
							"Prenom"+" "+"Nom"+
							" de la base de données?");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
