package ihm.actions;

import general.Constantes;
import ihm.fenetres.FenetreModifier;
import ihm.fenetres.FenetrePayerBillets;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.ListeObjet;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetrePayerBilletsAction extends AbstractAction {
	
	private ListeObjet listeObjet;
	
	/** L'action FenetreModifier permet l'appel de la fenetre Modifier
	 * 
	 * @param listeObjet la liste d'objets selectionnee
	 * @see ListeObjet
	 * @see FenetreModifier
	 * @see AbstractAction
	 */
	public FenetrePayerBilletsAction(ListeObjet listeObjet) {
        super("Payer Billets");
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
				new FenetrePayerBillets((Personne) listeObjet.getObjetByIndex(selectionCorrige), new ValiderPaiementAction());
			} catch (Exception e1) {
				Constantes.afficherException(e1);
			}
    	}
    }
}