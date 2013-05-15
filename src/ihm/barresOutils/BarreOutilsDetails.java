package ihm.barresOutils;

import ihm.actions.AnnulerAction;
import ihm.actions.valider.ValiderDonBilletAction;
import ihm.actions.valider.ValiderPaiementAction;
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
		this.add(new JButton(new ValiderPaiementAction(listeAchats, tableau)));
		this.add(new JButton(new ValiderDonBilletAction(listeAchats, tableau)));
		this.add(new JButton(new AnnulerAction(fenetre, "Fermer")));
	}
}