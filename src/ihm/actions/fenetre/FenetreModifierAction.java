package ihm.actions.fenetre;

import general.Constantes;
import general.Langue;
import ihm.fenetres.FenetreModifier;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.ListeObjet;
import modele.Objet;

@SuppressWarnings("serial")
public class FenetreModifierAction extends AbstractAction {
	
	private ListeObjet listeObjet;
	
	/** L'action FenetreModifier permet l'appel de la fenetre Modifier
	 * 
	 * @param listeObjet la liste d'objets selectionnee
	 * @see ListeObjet
	 * @see FenetreModifier
	 * @see AbstractAction
	 */
	public FenetreModifierAction(ListeObjet listeObjet) {
        super(Langue.getTraduction("modify"));
    	this.listeObjet = listeObjet;
    }

	/** Methode requise par l'heritage de la classe AbstractAction
	 * Lorsque l'action est appelee, cette methode est appelee.
	 * Si aucun objet n'est selectionnee, une fenetre d'avertissement apparait.
	 * Si une erreur apparait lors de la recuperation des donnees de l'objet dans la base
	 * de donnees, les traces de l'exception sont affichees graphiquement.
	 * Sinon la fenetre Modifier est appelee.
	 * 
	 * @see FenetreModifier
	 * @see AbstractAction
	 */
    public void actionPerformed(ActionEvent e) {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				boolean select = true;
				int selectionCorrige = 0;
				int selection = listeObjet.getTableau().getSelectedRow();
				try {
            	selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
				} catch (Exception e) {	
					select = false;
					JOptionPane.showMessageDialog(new JFrame(), 
							Langue.selectionVide, Langue.avertissement, JOptionPane.INFORMATION_MESSAGE);
            	}
				if(select) {
					try {
						Objet objet = listeObjet.getObjetByIndex(selectionCorrige);
						new FenetreModifier(objet, listeObjet);
					} catch (Exception e1) {
						Constantes.afficherException(e1);
					}
				}
			}
		});
    }
}
