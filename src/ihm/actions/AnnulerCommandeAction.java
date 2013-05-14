package ihm.actions;

import ihm.fenetres.Fenetre;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.Commande;

@SuppressWarnings("serial")
public class AnnulerCommandeAction extends AbstractAction {
	Commande commande;
	Fenetre fenetre;
	
	public AnnulerCommandeAction (Commande commande, Fenetre fenetre) {
		super("Annuler");
		this.commande = commande;
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		commande.annuler();
		fenetre.dispose();
		
	}
}
