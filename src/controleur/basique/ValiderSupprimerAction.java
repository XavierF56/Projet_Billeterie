package controleur.basique;

import general.Constantes;
import general.Langue;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vue.fenetres.Fenetre;

import modele.ListeObjet;


@SuppressWarnings("serial")
public class ValiderSupprimerAction extends AbstractAction {
	private ListeObjet listeObjet;
	private Fenetre fenetre;
	
	/**
	 * Cette classe permet la gestion de la validation de la suppression d'une liste d'objets (Billets ou Personnes) de la base de données par l'utilisateur.
	 * 
	 * @param listeObjet la liste des objets à supprimer
	 * @param fenetre la fenetre en cours
	 */
	public ValiderSupprimerAction(ListeObjet listeObjet, Fenetre fenetre) {
        super(Langue.getTraduction("validate"));
    	this.listeObjet = listeObjet;
    	this.fenetre = fenetre;
    }

	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
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
						Langue.getTraduction("error_empty_selection"), Langue.getTraduction("warning"), JOptionPane.INFORMATION_MESSAGE);
        	}
			if(select) {
				Arrays.sort(modelIndexes);
	            for(int i = modelIndexes.length - 1; i >= 0; i--){
	            	listeObjet.getObjetByIndex(modelIndexes[i]).supprimer();
	            }
				
			}
			fenetre.dispose();
        } catch (Exception e1) {
        	Constantes.afficherException(e1);
        }
    }
}