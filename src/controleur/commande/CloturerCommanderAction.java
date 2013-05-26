package controleur.commande;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Commande;
import vue.fenetres.Fenetre;

@SuppressWarnings("serial")
public class CloturerCommanderAction extends AbstractAction {
	private Fenetre fenetre;
	private Commande commande;
	
	public CloturerCommanderAction(Fenetre fenetre, Commande commande) {
	    super(Langue.getTraduction("ok"));
	    this.fenetre = fenetre;
	    this.commande = commande;
	}
	
	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			commande.cloturer();
			fenetre.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), Langue.getTraduction("error_purchase"), Langue.getTraduction("error"), JOptionPane.ERROR_MESSAGE);
			fenetre.dispose();
		}
	}
}