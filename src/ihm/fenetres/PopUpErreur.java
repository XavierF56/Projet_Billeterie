package ihm.fenetres;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PopUpErreur extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public PopUpErreur(String titre, String message) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle(titre);

		this.add(new JLabel(message), "North");
		this.add(new JButton(new ValiderAction(this)), "South");
		
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
