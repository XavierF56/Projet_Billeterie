package ihm.actions;

import ihm.fenetres.FenetreDetails;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	    	boolean select = true;
	    	int selectionCorrige = 0;
	    	int selection = listeObjet.getTableau().getSelectedRow();
	    	try{
        	selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
		    } catch (Exception e1) {	
				select = false;
				JOptionPane.showMessageDialog(new JFrame(), 
						"La selection est vide", "Attention", JOptionPane.INFORMATION_MESSAGE);
		    }
	    	if(select) {
		    	try {
					new FenetreDetails((Personne) listeObjet.getObjetByIndex(selectionCorrige));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
	    	}
	    }
	}