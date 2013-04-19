package ihm.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.ListeObjet;


public class SupprimerAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private ListeObjet listeObjet;
	
	public SupprimerAction(ListeObjet listeObjet) {
        super("Supprimer");
    	this.listeObjet = listeObjet;
    }

    public void actionPerformed(ActionEvent e) {
        try {
        	boolean select = true;
        	int selectionCorrige = 0;
        	int selection = listeObjet.getTableau().getSelectedRow();
        	try{
        	selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
        	} catch (Exception e1) {	
				select = false;
				JOptionPane.showMessageDialog(new JFrame(), 
						"Vous n'avez pas de selection a supprimer", "Attention", JOptionPane.INFORMATION_MESSAGE);
        	}
			if(select) {
				listeObjet.getObjetByIndex(selectionCorrige).supprimer();
			}
        } catch (Exception e1) {
        	e1.printStackTrace();
        }
    }
}