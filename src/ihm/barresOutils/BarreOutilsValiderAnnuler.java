package ihm.barresOutils;

import javax.swing.JButton;
import javax.swing.JPanel;

import ihm.actions.AnnulerPopUpAction;
import ihm.actions.ValiderPopUpAction;
import ihm.fenetres.Fenetre;

@SuppressWarnings("serial")
public class BarreOutilsValiderAnnuler extends JPanel {
	public BarreOutilsValiderAnnuler(Fenetre fenetre) {
		this.add(new JButton(new ValiderPopUpAction(fenetre)));
		this.add(new JButton(new AnnulerPopUpAction(fenetre)));	
	}
}
