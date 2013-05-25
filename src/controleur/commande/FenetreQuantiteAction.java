package controleur.commande;

import general.Constantes;
import general.Langue;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import vue.fenetres.FenetreCommander;
import vue.fenetres.FenetreCommandeAjouter;

import modele.Billet;
import modele.Commande;
import modele.ListeBillets;

@SuppressWarnings("serial")
public class FenetreQuantiteAction extends AbstractAction {
	
	private FenetreCommander fenetreCommander;
	private ListeBillets listeBillets;
	private JTable tableau;
	private Commande commande;
	
	/** L'action FenetreQuantite permet l'appel de la fenetre Quantite
	 * 
	 * @param listeBillets la liste des billets
	 * @param tableau une copie modifiable du tableau
	 * @param commande la commande en cours
	 * @see ListeBillets
	 * @see Commande
	 * @see FenetreCommandeAjouter
	 * @see AbstractAction
	 */
	public FenetreQuantiteAction(FenetreCommander fenetreCommander, ListeBillets listeBillets, JTable tableau, Commande commande) {
	    super(Langue.getTraduction("add_to_shopping"));
	    this.fenetreCommander = fenetreCommander;
	    this.listeBillets = listeBillets;
	    this.tableau = tableau;
	    this.commande = commande;
	}
	
	/** Methode requise par l'heritage de la classe AbstractAction
	 * Lorsque l'action est appelee, cette methode est appelee.
	 * Si aucun billet n'est selectionne, une fenetre d'avertissement apparait.
	 * Si une erreur apparait lors de la recuperation des donnees du billets dans la base
	 * de donnees, les traces de l'exception sont affichees graphiquement.
	 * Sinon la fenetre Quantite est appelee.
	 * 
	 * @see FenetreCommandeAjouter
	 * @see AbstractAction
	 */
	public void actionPerformed(ActionEvent e) {
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
							Langue.getTraduction("error_empty_selection"), Langue.getTraduction("warning"), JOptionPane.INFORMATION_MESSAGE);
            	}
				if(select) {
					// Cas ou un billet est bien selectionne
					try {
						Billet billet = (Billet) listeBillets.getObjetByIndex(selectionCorrige);
						new FenetreCommandeAjouter(fenetreCommander, billet, listeBillets, commande);
					} catch (Exception e1) {
						Constantes.afficherException(e1);
					}		
				}
			}
		});
    }
}
