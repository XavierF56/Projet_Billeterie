package ihm.fenetres;

import ihm.actions.AnnulerCommandeAction;
import ihm.actions.valider.ValiderCommandeAction;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Commande;

@SuppressWarnings("serial")
public class FenetreCommanderForcer extends Fenetre {
	public FenetreCommanderForcer(Commande commande, String erreur, FenetreCommander fenetreCommande) {
		//Fenetre
		this.setTitle("Arreur lors de l'achat");
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
		JLabel label = new JLabel(erreur +"\n Voulez-vous quand meme valider cet achat ?");
		fenetre.add(label, "Center");
		
		this.afficher();
	}
}
