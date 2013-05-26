package vue.barreOutils;

import general.Langue;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import controleur.basique.AnnulerAction;
import controleur.details.ValiderDonBilletAction;
import controleur.details.ValiderPaiementAction;

import vue.fenetres.FenetreDetails;

import modele.ListeAchats;

@SuppressWarnings("serial")
public class BarreOutilsDetails extends JPanel {
	
	/**
	 * Cette classe permet l'affichage des boutons de la barre d'outils de la fenetre Details
	 * 
	 * @param fenetre la fenetre Details ouverte
	 * @param listeAchats la liste des achats de la personne selectionne
	 * @param tableau une copie du tableau des billets
	 * @see FenetreDetails
	 * @see ListeAchats
	 * @see JTable
	 */
	public BarreOutilsDetails(FenetreDetails fenetre, ListeAchats listeAchats, JTable tableau) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(new JButton(new ValiderPaiementAction(listeAchats, tableau)));
		this.add(new JButton(new ValiderDonBilletAction(listeAchats, tableau)));
		this.add(new JButton(new AnnulerAction(fenetre, Langue.getTraduction("close"))));
	}
}