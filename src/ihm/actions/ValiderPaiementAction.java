package ihm.actions;

import ihm.fenetres.FenetrePayerDonnerBillets;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ValiderPaiementAction extends AbstractAction implements KeyListener {

	private FenetrePayerDonnerBillets fenetre;
	
	public ValiderPaiementAction(FenetrePayerDonnerBillets fenetre) {
		super("Payer");
		this.fenetre = fenetre;
	}
	
	private void valider() {
		try {
	    	fenetre.dispose();
		} catch (Exception e1) {
			String message = "\"Erreur lors de la modification\"\n"
			            + "Tous les champs n'ont pas ete renseignes\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Erreur", JOptionPane.ERROR_MESSAGE);
		}
    }
	
	public void actionPerformed(ActionEvent e) {
		valider();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
