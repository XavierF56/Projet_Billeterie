package controleur.commande;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import vue.fenetres.Fenetre;
import vue.fenetres.FenetreCommander;

import modele.Commande;

@SuppressWarnings("serial")
public class ValiderCommandeAction extends AbstractAction {
	Commande commande;
	Fenetre fenetre;
	FenetreCommander fenetreCommande;

	public ValiderCommandeAction (Commande commande, Fenetre fenetre, FenetreCommander fenetreCommande) {
		super(Langue.getTraduction("force"));
		this.commande = commande;
		this.fenetre = fenetre;
		this.fenetreCommande = fenetreCommande;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		commande.valider();
		fenetreCommande.getBilleterie().getFenetre().getOngletStats().majLabel();
		fenetre.dispose();
		fenetreCommande.majLabel();
	}
	
}
