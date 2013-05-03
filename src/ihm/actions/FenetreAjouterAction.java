package ihm.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import modele.ListeObjet;

import ihm.fenetres.FenetreAjouter;

@SuppressWarnings("serial")
public class FenetreAjouterAction extends AbstractAction {
	private ListeObjet listeObjet;
	private String titre;
	
	public FenetreAjouterAction(ListeObjet listeObjet, String titre) {
        super("Ajouter");
    	this.listeObjet = listeObjet;
    	this.titre = titre;
    }

    public void actionPerformed(ActionEvent e) {
    	new FenetreAjouter(listeObjet, titre);
    }
}