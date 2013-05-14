package ihm.barresOutils;

import ihm.actions.AnnulerAction;
import ihm.actions.ValiderDonBilletAction;
import ihm.actions.ValiderPaiementAction;
import ihm.fenetres.FenetreDetails;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import modele.ListeAchats;

@SuppressWarnings("serial")
public class BarreOutilsDetails extends JPanel {
	
	public BarreOutilsDetails(FenetreDetails fenetre, ListeAchats listeAchats, JTable tableau) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(new JButton(new ValiderPaiementAction(fenetre, listeAchats, tableau)));
		this.add(new JButton(new ValiderDonBilletAction(fenetre, listeAchats, tableau)));
		this.add(new JButton(new AnnulerAction(fenetre)));
	}
}