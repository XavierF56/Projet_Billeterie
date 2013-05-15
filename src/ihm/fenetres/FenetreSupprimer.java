package ihm.fenetres;

import ihm.actions.AnnulerAction;
import ihm.actions.valider.ValiderSupprimerAction;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class FenetreSupprimer extends Fenetre {
	
	/**
	 * 
	 * @param listeObjet
	 */
	public FenetreSupprimer(ListeObjet listeObjets) {
		
		//Fenetre
		this.setTitle("Confirmation de la suppression");
		JPanel fenetre = new JPanel(new BorderLayout());
		fenetre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(fenetre);
		
		//Boutons Valider et Annuler
		JButton buttonAnnuler = new JButton(new AnnulerAction(this, "Annuler"));
		JButton buttonSupprimer = new JButton(new ValiderSupprimerAction(listeObjets, this));
		JPanel panelSouth = new JPanel();
		panelSouth.add(buttonSupprimer);
		panelSouth.add(buttonAnnuler);
		fenetre.add(panelSouth, "South");
		
		//Message
		JLabel label = new JLabel("Voulez-vous vraiment supprimer ?");
		fenetre.add(label, "Center");
		
		this.afficher();
	}
}