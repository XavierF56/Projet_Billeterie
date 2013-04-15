package ihm.actions;

import ihm.fenetres.FenetreDetailsPersonne;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.ListeObjet;
import modele.Personne;

public class VoirAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private ListeObjet listeObjet;
		
		public VoirAction(ListeObjet listeObjet) {
	        super("Details");
	    	this.listeObjet = listeObjet;
	    }

	    public void actionPerformed(ActionEvent e) {
	    	int selection = listeObjet.getTableau().getSelectedRow();
        	int selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
	    	try {
				new FenetreDetailsPersonne((Personne) listeObjet.getObjetByIndex(selectionCorrige));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	}