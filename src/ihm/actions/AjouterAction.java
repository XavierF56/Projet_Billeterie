package ihm.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import modele.ListeObjet;

import ihm.fenetres.FenetreNouvelleObjet;

@SuppressWarnings("serial")
public class AjouterAction extends AbstractAction {
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