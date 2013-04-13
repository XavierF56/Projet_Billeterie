package ihm.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
        	int selection = listeObjet.getTableau().getSelectedRow();
        	int selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
        	listeObjet.getObjetByIndex(selectionCorrige).supprimer();
        } catch (Exception e1) {
        	
        }
    }
}