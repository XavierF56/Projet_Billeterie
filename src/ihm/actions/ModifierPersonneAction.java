package ihm.actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import ihm.fenetres.FenetrePopUp;


@SuppressWarnings("serial")
public class ModifierPersonneAction extends AbstractAction {
    public ModifierPersonneAction() {
        super("Modifier");
    }

    public void actionPerformed(ActionEvent e) {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePopUp frame = new FenetrePopUp("Modifier informations");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
