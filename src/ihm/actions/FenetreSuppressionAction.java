package ihm.actions;

import ihm.fenetres.FenetreSuppressionObjet;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.ListeObjet;

public class FenetreSuppressionAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private ListeObjet listeObjet;
	
	public FenetreSuppressionAction (ListeObjet listeObjet) {
		super("Supprimer");
    	this.listeObjet = listeObjet;
    }

    public void actionPerformed(ActionEvent e) {
    	new FenetreSuppressionObjet(listeObjet);
    }
}
