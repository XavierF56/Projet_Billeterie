package ihm.actions;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.ListeObjet;
import modele.Objet;

import ihm.fenetres.FenetreModifieObjet;


public class ModifierAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private ListeObjet listeObjet;
	
	public ModifierAction(ListeObjet listeObjet) {
        super("Modifier");
    	this.listeObjet = listeObjet;
    }

    public void actionPerformed(ActionEvent e) {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int selection = listeObjet.getTableau().getSelectedRow();
	            	int selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
	            	Objet objet = listeObjet.getObjetByIndex(selectionCorrige);
					new FenetreModifieObjet(objet, listeObjet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
