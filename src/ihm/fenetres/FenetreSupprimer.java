package ihm.fenetres;

import ihm.actions.AnnulerAction;
import ihm.actions.ValiderSupprimerAction;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import modele.ListeObjet;

public class FenetreSupprimer  extends Fenetre {
	private static final long serialVersionUID = 1L;
	private ListeObjet listeObjets;
	
	public FenetreSupprimer(ListeObjet listeObjet) {
		this.listeObjets = listeObjet;
		
		//Fenetre
		this.setTitle("Confirmation de la suppression");
		JPanel fenetre = new JPanel(new BorderLayout());
		fenetre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(fenetre);
		
		//Bouton Valider
		JButton buttonAnnuler = new JButton(new AnnulerAction(this));
		JButton buttonSupprimer = new JButton(new ValiderSupprimerAction(listeObjets, this));
		JPanel panelSouth = new JPanel();
		panelSouth.add(buttonAnnuler);
		panelSouth.add(buttonSupprimer);

		fenetre.add(panelSouth, "South");
		
		this.afficher();
	}
}
