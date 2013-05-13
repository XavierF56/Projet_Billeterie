package ihm.barresOutils;

import ihm.actions.AnnulerAction;
import ihm.actions.ValiderDonBilletAction;
import ihm.actions.ValiderPaiementAction;
import ihm.fenetres.Fenetre;
import ihm.fenetres.FenetrePayerDonnerBillets;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BarreOutilsDetails extends JPanel {
	
	public BarreOutilsDetails(Fenetre fenetre) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(new JButton(new ValiderPaiementAction((FenetrePayerDonnerBillets) fenetre)));
		this.add(new JButton(new ValiderDonBilletAction((FenetrePayerDonnerBillets) fenetre)));
		this.add(new JButton(new AnnulerAction(fenetre)));
	}
}