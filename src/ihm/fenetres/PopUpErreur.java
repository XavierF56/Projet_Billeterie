package ihm.fenetres;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PopUpErreur extends Fenetre{
	private static final long serialVersionUID = 1L;
	
	public PopUpErreur(String titre, String message) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle(titre);

		this.add(new JLabel(message), "North");
		this.add(new JButton(new ValiderAction(this)), "South");
		this.ajusterEtCentrer();
		setVisible(true);
	}
	
	private class ValiderAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		PopUpErreur fenetre;
        private ValiderAction(PopUpErreur fenetre) {
            super("OK");
            this.fenetre = fenetre;
        }
 
        public void actionPerformed(ActionEvent e) {
			fenetre.setVisible(false);
        }
    }
}
