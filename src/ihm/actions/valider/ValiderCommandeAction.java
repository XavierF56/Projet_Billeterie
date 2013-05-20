package ihm.actions.valider;

import general.Langue;
import ihm.fenetres.Fenetre;
import ihm.fenetres.FenetreCommander;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
