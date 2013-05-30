package controleur.details;

import general.Constantes;
import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vue.fenetres.FenetreDetails;

import modele.Billetterie;
import modele.ListeObjet;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetreDetailsAction extends AbstractAction {

		private Billetterie billeterie;
		
		/** 
		 * Cette classe permet la gestion de l'affichage de la fenêtre Details.
		 * 
		 * @param billeterie la billeterie en cours
		 * @see Billetterie
		 * @see FenetreDetails
		 * @see AbstractAction
		 */
		public FenetreDetailsAction(Billetterie billeterie) {
	        super(Langue.getTraduction("details"));
	    	this.billeterie = billeterie;
	    }

		/** Methode requise par l'heritage de la classe AbstractAction
		 * Lorsque l'action est appelee, cette methode est appelee.
		 * Si aucun objet n'est selectionnee, une fenetre d'avertissement apparait.
		 * Si une erreur apparait lors de la recuperation des donnees de l'objet dans la base
		 * de donnees, les traces de l'exception sont affichees graphiquement.
		 * Sinon la fenetre Details est appelee.
		 * 
		 * @see FenetreDetails
		 * @see AbstractAction
		 */
	    public void actionPerformed(ActionEvent e) {
	    	boolean select = true;
	    	int selectionCorrige = 0;
	    	ListeObjet listeObjet = billeterie.getListePersonnes();
	    	int selection = listeObjet.getTableau().getSelectedRow();
	    	try{
	    		selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
		    } catch (Exception e1) {	
				select = false;
				JOptionPane.showMessageDialog(new JFrame(), 
						Langue.getTraduction("error_empty_selection"), Langue.getTraduction("warning"), JOptionPane.INFORMATION_MESSAGE);
		    }
	    	if(select) {
		    	try {
					new FenetreDetails((Personne) listeObjet.getObjetByIndex(selectionCorrige));
				} catch (Exception e1) {
					Constantes.afficherException(e1);
				}
	    	}
	    }
	}