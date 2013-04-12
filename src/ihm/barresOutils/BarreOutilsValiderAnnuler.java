package ihm.barresOutils;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import ihm.actions.AnnulerPopUpAction;
import ihm.actions.ValiderPopUpAction;

@SuppressWarnings("serial")
public class BarreOutilsValiderAnnuler extends JPanel {
	public BarreOutilsValiderAnnuler(JDialog fenetre) {
		this.add(new JButton(new ValiderPopUpAction(fenetre)));
		this.add(new JButton(new AnnulerPopUpAction(fenetre)));	
	}
}
