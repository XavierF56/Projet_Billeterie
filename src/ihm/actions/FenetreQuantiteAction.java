package ihm.actions;

import general.Constantes;
import ihm.fenetres.FenetreCommander;
import ihm.fenetres.FenetreQuantite;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

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
	 * @see FenetreQuantite
	 * @see AbstractAction
	 */
	public FenetreQuantiteAction(FenetreCommander fenetreCommander, ListeBillets listeBillets, JTable tableau, Commande commande) {
	    super("Ajouter au panier");
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
	 * @see FenetreQuantite
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
							"Vous n'avez pas de selectionne de billet", "Attention", JOptionPane.INFORMATION_MESSAGE);
            	}
				if(select) {
					// Cas ou un billet est bien selectionne
					try {
						Billet billet = (Billet) listeBillets.getObjetByIndex(selectionCorrige);
						new FenetreQuantite(fenetreCommander, billet, listeBillets, commande);
					} catch (Exception e1) {
						Constantes.afficherException(e1);
					}		
				}
			}
		});
    }
}
