package ihm.actions;

import ihm.fenetres.Fenetre;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.ListeObjet;


@SuppressWarnings("serial")
public class ValiderSupprimerAction extends AbstractAction {
	private ListeObjet listeObjet;
	Fenetre fenetre;
	
	public ValiderSupprimerAction(ListeObjet listeObjet, Fenetre fenetre) {
        super("Valider");
    	this.listeObjet = listeObjet;
    	this.fenetre = fenetre;
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
			fenetre.dispose();
        } catch (Exception e1) {
        	e1.printStackTrace();
        }
    }
}