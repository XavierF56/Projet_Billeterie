package ihm.barresOutils;

import ihm.fenetres.FenetreDetailsPersonne;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;

import modele.ListeObjet;
import modele.Personne;

public class VoirAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private ListeObjet listeObjet;
	
	public VoirAction(ListeObjet listeObjet) {
        super("Details");
    	this.listeObjet = listeObjet;
    }
	public void actionPerformed(ActionEvent e) {
        try {
        	int selection = listeObjet.getTableau().getSelectedRow();
        	int selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
        	new FenetreDetailsPersonne((Personne) listeObjet.getObjetByIndex(selectionCorrige));
        } catch (Exception e1) {
        	
        }
    }

}
