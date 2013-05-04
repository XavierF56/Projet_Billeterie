package ihm.actions;

import ihm.fenetres.FenetreQuantite;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Billet;
import modele.ListeBillets;

@SuppressWarnings("serial")
public class AjouterAuPanierAction extends AbstractAction {
	private ListeBillets listeBillets;
	
	public AjouterAuPanierAction(ListeBillets listeBillets) {
	    super("Ajouter au panier");
	    this.listeBillets = listeBillets;
	}
	
	public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					boolean select = true;
					int selectionCorrige = 0;
					int selection = listeBillets.getTableau().getSelectedRow();
					try {
						selectionCorrige = listeBillets.getTableau().getRowSorter().convertRowIndexToModel(selection);
					} catch (Exception e) {	
						select = false;
						JOptionPane.showMessageDialog(new JFrame(), 
								"Vous n'avez pas de selectionne de billet", "Attention", JOptionPane.INFORMATION_MESSAGE);
	            	}
					if(select) {
						Billet billet = (Billet) listeBillets.getObjetByIndex(selectionCorrige);
						new FenetreQuantite(billet, listeBillets);
					}
				} catch (Exception e) {		
					e.printStackTrace();
				}
			}
		});
    }
}
