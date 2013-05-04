package ihm.actions;

import ihm.fenetres.FenetreQuantite;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import modele.Billet;
import modele.ListeBillets;

@SuppressWarnings("serial")
public class AjouterAuPanierAction extends AbstractAction {
	private ListeBillets listeBillets;
	JTable tableau;
	
	public AjouterAuPanierAction(ListeBillets listeBillets, JTable tableau) {
	    super("Ajouter au panier");
	    this.listeBillets = listeBillets;
	    this.tableau = tableau;
	}
	
	public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					boolean select = true;
					int selectionCorrige = 0;
					//int selection = listeBillets.getTableau().getSelectedRow(); remplace par :
					int selection = tableau.getSelectedRow();
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
