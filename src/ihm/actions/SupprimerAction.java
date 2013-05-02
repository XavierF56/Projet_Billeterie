package ihm.actions;

import java.awt.event.ActionEvent;
import java.util.Arrays;

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
        	int[] selection = listeObjet.getTableau().getSelectedRows();
            int[] modelIndexes = new int[selection.length];
     
            
        	try{
        		for(int i = 0; i < selection.length; i++){
                    modelIndexes[i] = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection[i]);
                }        	
        	} catch (Exception e1) {	
				select = false;
				JOptionPane.showMessageDialog(new JFrame(), 
						"Vous n'avez pas de selection a supprimer", "Attention", JOptionPane.INFORMATION_MESSAGE);
        	}
			if(select) {
				Arrays.sort(modelIndexes);
			     
	            for(int i = modelIndexes.length - 1; i >= 0; i--){
	            	listeObjet.getObjetByIndex(modelIndexes[i]).supprimer();
	            }
				
			}
        } catch (Exception e1) {
        	e1.printStackTrace();
        }
    }
}