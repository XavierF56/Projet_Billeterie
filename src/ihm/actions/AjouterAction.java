package ihm.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import modele.ListeObjet;

import ihm.fenetres.FenetreNouvelleObjet;

public class AjouterAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	private ListeObjet listeObjet;
	private String titre;
	
	public AjouterAction(ListeObjet listeObjet, String titre) {
        super("Ajouter");
    	this.listeObjet = listeObjet;
    	this.titre = titre;
    }

    public void actionPerformed(ActionEvent e) {
    	new FenetreNouvelleObjet(listeObjet, titre);
    }
}