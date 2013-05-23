package vue.fenetres;


import general.Langue;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import vue.outils.MultiLineLabel;

import controleur.commande.AnnulerCommandeAction;
import controleur.commande.CompleterCommandeAction;
import controleur.commande.ForcerCommandeAction;

import modele.Commande;

@SuppressWarnings("serial")
public class FenetreCommanderErreur extends Fenetre {
	public FenetreCommanderErreur(Commande commande, String erreur, FenetreCommander fenetreCommande) {
		
		//Fenetre
		this.setTitle(Langue.getTraduction("error_buying"));
		JPanel fenetre = new JPanel(new BorderLayout());
		fenetre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(fenetre);
		
		//Boutons Valider et Annuler
		JButton buttonAnnuler = new JButton(new AnnulerCommandeAction(commande, this));
		JButton buttonSupprimer = new JButton(new ForcerCommandeAction(commande, this, fenetreCommande));
		JButton buttonCompleter = new JButton(new CompleterCommandeAction(commande, this, fenetreCommande));
		JPanel panelSouth = new JPanel();
		panelSouth.add(buttonAnnuler);
		panelSouth.add(buttonSupprimer);
		panelSouth.add(buttonCompleter);
		fenetre.add(panelSouth, "South");
		
		//Message
		MultiLineLabel multiLineLabel = new MultiLineLabel(erreur + "\n" + Langue.getTraduction("validate_anyway"));

		fenetre.add(multiLineLabel, "Center");
		
		this.afficherDialog();
	}
}
