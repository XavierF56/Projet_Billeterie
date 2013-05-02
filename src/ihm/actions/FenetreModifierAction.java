package ihm.actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.ListeObjet;
import modele.Objet;

import ihm.fenetres.FenetreModifieObjet;

@SuppressWarnings("serial")
public class FenetreModifierAction extends AbstractAction {
	private ListeObjet listeObjet;
	
	public FenetreModifierAction(ListeObjet listeObjet) {
        super("Modifier");
    	this.listeObjet = listeObjet;
    }

    public void actionPerformed(ActionEvent e) {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					boolean select = true;
					int selectionCorrige = 0;
					int selection = listeObjet.getTableau().getSelectedRow();
					try {
	            	selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
					} catch (Exception e) {	
						select = false;
						JOptionPane.showMessageDialog(new JFrame(), 
								"Vous n'avez pas de selection a modifier", "Attention", JOptionPane.INFORMATION_MESSAGE);
	            	}
					if(select) {
						Objet objet = listeObjet.getObjetByIndex(selectionCorrige);
						new FenetreModifieObjet(objet, listeObjet);
					}
				} catch (Exception e) {		
					e.printStackTrace();
				}
			}
		});
    }
}
