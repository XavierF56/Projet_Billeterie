package ihm.actions;

import general.Constantes;
import ihm.fenetres.FenetreCommander;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Billeterie;
import modele.ListeBillets;
import modele.ListeObjet;
import modele.Objet;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetreCommanderAction extends AbstractAction {
	
	private ListeObjet listeObjets;
	private Billeterie billeterie;

	/** L'action FenetreCommander permet l'appel de la fenetre Commander
	 * 
	 * @param listeObjets la liste des objets selectionnes
	 * @param billeterie la billeterie en cours
	 * @see ListeBillets
	 * @see Billeterie
	 * @see FenetreCommander
	 * @see AbstractAction
	 */
	public FenetreCommanderAction(ListeObjet listeObjets, Billeterie billeterie) {
		super("Commander Billet");
		this.listeObjets = listeObjets;
		this.billeterie = billeterie;
	}

	/** Methode requise par l'heritage de la classe AbstractAction
	 * Lorsque l'action est appelee, cette methode est appelee.
	 * Si aucun objet n'est selectionnee, une fenetre d'avertissement apparait.
	 * Si une erreur apparait lors de la recuperation des donnees de l'objet dans la base
	 * de donnees, les traces de l'exception sont affichees graphiquement.
	 * Sinon la fenetre Commander est appelee.
	 * 
	 * @see FenetreCommander
	 * @see AbstractAction
	 */
	public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				boolean select = true;
				int selectionCorrige = 0;
				int selection = listeObjets.getTableau().getSelectedRow();
				try {
            	selectionCorrige = listeObjets.getTableau().getRowSorter().convertRowIndexToModel(selection);
				} catch (Exception e) {	
					select = false;
					JOptionPane.showMessageDialog(new JFrame(), 
							"Vous n'avez sélectionnée personne", "Attention", JOptionPane.INFORMATION_MESSAGE);
            	}
				if(select) {
					try {
						Objet objet = listeObjets.getObjetByIndex(selectionCorrige);
						new FenetreCommander((Personne) objet, billeterie);
					} catch (Exception e1) {		
						Constantes.afficherException(e1);
					}
				}
			}
		});
	}
}
