package controleur.commande;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import vue.fenetres.Fenetre;

import modele.Commande;

@SuppressWarnings("serial")
public class AnnulerCommandeAction extends AbstractAction {
	Commande commande;
	Fenetre fenetre;
	
	public AnnulerCommandeAction (Commande commande, Fenetre fenetre) {
		super(Langue.getTraduction("cancel"));
		this.commande = commande;
		this.fenetre = fenetre;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		commande.annuler();
		fenetre.dispose();
		
	}
}
