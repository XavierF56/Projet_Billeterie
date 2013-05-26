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
	
	/**
	 * Cette classe permet la gestion de l'affichage de la fenêtre d'erreur associé à une commande dont les paramètres ne sont pas valides
	 * 
	 * @param commande la commande en cours
	 * @param erreur le texte de l'erreur
	 * @param fenetreCommande la fenetre Commande en cours
	 * @param completer
	 */
	public FenetreCommanderErreur(Commande commande, String erreur, FenetreCommander fenetreCommande, boolean completer) {
		
		/* Fenêtre */
		this.setTitle(Langue.getTraduction("error_buying"));
		JPanel fenetre = new JPanel(new BorderLayout());
		fenetre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(fenetre);
		
		/* Boutons */
		JButton buttonAnnuler = new JButton(new AnnulerCommandeAction(commande, this));
		
		JPanel panelSouth = new JPanel();
		
		if(completer) {
			JButton buttonCompleter = new JButton(new CompleterCommandeAction(commande, this, fenetreCommande));
			panelSouth.add(buttonCompleter);
		}
		JButton buttonForcer = new JButton(new ForcerCommandeAction(commande, this, fenetreCommande));
		panelSouth.add(buttonForcer);
		panelSouth.add(buttonAnnuler);
		
		fenetre.add(panelSouth, "South");
		
		/* Message */
		if(completer) {
			MultiLineLabel multiLineLabel = new MultiLineLabel(erreur + "\n" + Langue.getTraduction("validate_anyway"));
			fenetre.add(multiLineLabel, "Center");
		} else {
			MultiLineLabel multiLineLabel = new MultiLineLabel(erreur + "\n" + Langue.getTraduction("validate_anyway_force"));
			fenetre.add(multiLineLabel, "Center");
		}
		
		/* Affichage de la fenetre */
		this.afficherDialog();
	}
}
