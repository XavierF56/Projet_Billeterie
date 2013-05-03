package ihm.actions;

import ihm.fenetres.FenetreSupprimer;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.ListeObjet;

public class FenetreSupprimerAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private ListeObjet listeObjet;
	
	public FenetreSupprimerAction (ListeObjet listeObjet) {
		super("Supprimer");
    	this.listeObjet = listeObjet;
    }

    public void actionPerformed(ActionEvent e) {
    	new FenetreSupprimer(listeObjet);
    }
}
