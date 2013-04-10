package ihm.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ValiderPopUpAction extends AbstractAction {
	
	private JDialog fenetre;
	
    public ValiderPopUpAction(JDialog fenetre2) {
    	super("Valider");
    	this.fenetre = fenetre2;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Validation");
        JOptionPane.showMessageDialog(new JFrame(), "Vous avez validé!", "Dialog", JOptionPane.INFORMATION_MESSAGE);
        fenetre.dispose();
    }
}