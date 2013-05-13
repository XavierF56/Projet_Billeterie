package ihm.actions;

import general.Constantes;
import ihm.fenetres.FenetreDetails;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import modele.Billet;
import modele.ListeBillets;
import modele.Personne;

@SuppressWarnings("serial")
public class ValiderPaiementAction extends AbstractAction implements KeyListener {

	private FenetreDetails fenetreDetails;
	private JTable tableau;
	private ListeBillets listeBillets;
	
	public ValiderPaiementAction(FenetreDetails fenetre, ListeBillets listeBillets, JTable tableau) {
		super("Payer");
		this.fenetreDetails = fenetre;
		this.tableau = tableau;
		this.listeBillets = listeBillets;
	}
	
	private void valider() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				boolean select = true;
				int selectionCorrige = 0;
				int selection = tableau.getSelectedRow();
				try {
					selectionCorrige = listeBillets.getTableau().getRowSorter().convertRowIndexToModel(selection);
				} catch (Exception e) {
					// Cas ou aucun billet n'est selectionne
					select = false;
					JOptionPane.showMessageDialog(new JFrame(), 
							"Vous n'avez pas de selectionne de billet", "Attention", JOptionPane.INFORMATION_MESSAGE);
            	}
				if(select) {
					// Cas ou un billet est bien selectionne
					try {
						Billet billet = (Billet) listeBillets.getObjetByIndex(selectionCorrige);
						Personne personne = fenetreDetails.getPersonne();
						System.out.println("" + personne + " paye le(s) billet(s) "+ billet);
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
