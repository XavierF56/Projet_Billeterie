package ihm.barresOutils;

import ihm.actions.AnnulerAction;
import ihm.actions.ValiderDonBilletAction;
import ihm.actions.ValiderPaiementAction;
import ihm.fenetres.FenetreDetails;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BarreOutilsDetails extends JPanel {
	
	public BarreOutilsDetails(FenetreDetails fenetre) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(new JButton(new ValiderPaiementAction(fenetre)));
		this.add(new JButton(new ValiderDonBilletAction(fenetre)));
		this.add(new JButton(new AnnulerAction(fenetre)));
	}
}