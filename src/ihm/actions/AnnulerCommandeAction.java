package ihm.actions;

import general.Langue;
import ihm.fenetres.Fenetre;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.Commande;

@SuppressWarnings("serial")
public class AnnulerCommandeAction extends AbstractAction {
	Commande commande;
	Fenetre fenetre;
	
	public AnnulerCommandeAction (Commande commande, Fenetre fenetre) {
		super(Langue.annuler);
		this.commande = commande;
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		commande.annuler();
		fenetre.dispose();
		
	}
}
