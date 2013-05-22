package vue.fenetres;


import general.Langue;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.commande.AnnulerCommandeAction;
import controleur.commande.ValiderCommandeAction;

import modele.Commande;

@SuppressWarnings("serial")
public class FenetreCommanderForcer extends Fenetre {
	public FenetreCommanderForcer(Commande commande, String erreur, FenetreCommander fenetreCommande) {
		
		//Fenetre
		this.setTitle(Langue.getTraduction("error_buying"));
		JPanel fenetre = new JPanel(new BorderLayout());
		fenetre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(fenetre);
		
		//Boutons Valider et Annuler
		JButton buttonAnnuler = new JButton(new AnnulerCommandeAction(commande, this));
		JButton buttonSupprimer = new JButton(new ValiderCommandeAction(commande, this, fenetreCommande));
		JPanel panelSouth = new JPanel();
		panelSouth.add(buttonSupprimer);
		panelSouth.add(buttonAnnuler);
		fenetre.add(panelSouth, "South");
		
		//Message
		JLabel label = new JLabel(erreur + "\n " + Langue.getTraduction("validate_anyway"));
		fenetre.add(label, "Center");
		
		this.afficherDialog();
	}
}
