package controleur.details;

import general.Constantes;
import general.Langue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import modele.Achat;
import modele.ListeAchats;

@SuppressWarnings("serial")
public class ValiderPaiementAction extends AbstractAction implements KeyListener {

	private JTable tableau;
	private ListeAchats listeAchats;
	
	public ValiderPaiementAction(ListeAchats listeAchats, JTable tableau) {
		super(Langue.getTraduction("pay"));
		this.tableau = tableau;
		this.listeAchats = listeAchats;
	}
	
	private void valider() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				boolean select = true;
				int selectionCorrige = 0;
				int selection = tableau.getSelectedRow();
				try {
					selectionCorrige = listeAchats.getTableau().getRowSorter().convertRowIndexToModel(selection);
				} catch (Exception e) {
					// Cas ou aucun billet n'est selectionne
					select = false;
					JOptionPane.showMessageDialog(new JFrame(), Langue.getTraduction("error_no_ticket_selected"), 
							Langue.getTraduction("warning"), JOptionPane.INFORMATION_MESSAGE);
            	}
				if(select) {
					// Cas ou un billet est bien selectionne
					try {
						Achat achat = (Achat) listeAchats.getObjetByIndex(selectionCorrige);
						if(!achat.getPaye()){
							achat.setPayer(true);
						} else {
							JOptionPane.showMessageDialog(new JFrame(), Langue.getTraduction("ticket_already_paid"),
									Langue.getTraduction("warning"), JOptionPane.INFORMATION_MESSAGE);
		            	
						}
					} catch (Exception e1) {
						Constantes.afficherException(e1);
					}		
				}
			}
		});
    }
	
	public void actionPerformed(ActionEvent e) {
		valider();
	}
	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
}
