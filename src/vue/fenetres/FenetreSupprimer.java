package vue.fenetres;


import general.Langue;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.basique.AnnulerAction;
import controleur.basique.ValiderSupprimerAction;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class FenetreSupprimer extends Fenetre {
	
	/**
	 * Cette classe permet la gestion de l'affichage de la fenêtre Supprimer.
	 * Cette fenêtre permet à l'utilisteur de supprimer des personnes ou des billets dans la base de données.
	 * 
	 * @param listeObjet la liste des objets à supprimer
	 */
	public FenetreSupprimer(ListeObjet listeObjets) {
		
		/* Fenêtre */
		this.setTitle(Langue.getTraduction("delete_confirmation"));
		JPanel fenetre = new JPanel(new BorderLayout());
		fenetre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(fenetre);
		
		/* Boutons Valider et Annuler */
		JButton buttonAnnuler = new JButton(new AnnulerAction(this, Langue.getTraduction("cancel")));
		JButton buttonSupprimer = new JButton(new ValiderSupprimerAction(listeObjets, this));
		JPanel panelSouth = new JPanel();
		panelSouth.add(buttonSupprimer);
		panelSouth.add(buttonAnnuler);
		fenetre.add(panelSouth, "South");
		
		/* Message */
		JLabel label = new JLabel(Langue.getTraduction("delete_query"));
		fenetre.add(label, "Center");
		
		/* Affichage de la fenêtre */
		this.afficherDialog();
	}
}